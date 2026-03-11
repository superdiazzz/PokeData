package com.zulhija_nanda.product.pokedata.utils

import android.content.Context
import androidx.datastore.dataStore
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SessionManager @Inject constructor(
    @ApplicationContext private val context: Context
){

    private val Context.dataStore by preferencesDataStore("session")

    private val USER_LOGGED_IN = booleanPreferencesKey("user_logged_in")
    private val USER_EMAIL = stringPreferencesKey("user_email")

    suspend fun saveLogin(email: String) {
        context.dataStore.edit { pref ->
            pref[USER_LOGGED_IN] = true
            pref[USER_EMAIL] = email
        }
    }

    suspend fun logout() {
        context.dataStore.edit { pref ->
            pref.clear()
        }
    }

    val isLoggedIn: Flow<Boolean> =
        context.dataStore.data.map {
            it[USER_LOGGED_IN] ?: false
        }

    val email: Flow<String?> =
        context.dataStore.data.map {
            it[USER_EMAIL]
        }


}