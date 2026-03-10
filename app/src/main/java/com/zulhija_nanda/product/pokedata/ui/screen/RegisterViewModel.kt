package com.zulhija_nanda.product.pokedata.ui.screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zulhija_nanda.product.pokedata.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val repository: UserRepository
) : ViewModel(){

    var email by mutableStateOf("")
    var password by mutableStateOf("")

    var registerSuccess by mutableStateOf(false)

    fun register() {

        viewModelScope.launch {

            repository.register(email, password)

            registerSuccess = true

        }

    }
}