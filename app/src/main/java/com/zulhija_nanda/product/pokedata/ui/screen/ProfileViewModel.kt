package com.zulhija_nanda.product.pokedata.ui.screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zulhija_nanda.product.pokedata.data.local.UserEntity
import com.zulhija_nanda.product.pokedata.data.local.dao.UserDao
import com.zulhija_nanda.product.pokedata.data.repository.UserRepository
import com.zulhija_nanda.product.pokedata.utils.SessionManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class ProfileUiState(
    val name: String = "",
    val email: String = ""
)

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val userDao: UserDao,
    private val sessionManager: SessionManager
) : ViewModel() {

    private val _uiState = MutableStateFlow(ProfileUiState())
    val uiState = _uiState.asStateFlow()

    fun loadProfile(email: String) {

        viewModelScope.launch {

            val user = userDao.getUserByEmail(email)

            if (user != null) {
                _uiState.update {
                    it.copy(
                        email = user.email
                    )
                }
            }

        }

    }

    fun logout() {
        viewModelScope.launch {
            sessionManager.logout()
        }
    }

}