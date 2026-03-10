package com.zulhija_nanda.product.pokedata.ui.screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zulhija_nanda.product.pokedata.data.local.UserEntity
import com.zulhija_nanda.product.pokedata.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val repository: UserRepository
): ViewModel(){

    var user by mutableStateOf<UserEntity?>(null)

    fun loadUser(email: String) {

        viewModelScope.launch {

            user = repository.getUser(email)

        }

    }

}