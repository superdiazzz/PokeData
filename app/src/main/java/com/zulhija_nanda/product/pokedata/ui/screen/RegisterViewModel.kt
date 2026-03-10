package com.zulhija_nanda.product.pokedata.ui.screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zulhija_nanda.product.pokedata.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


data class RegisterUiState(

    val email: String = "",
    val password: String = "",
    val loading: Boolean = false,
    val success: Boolean = false,
    val error: String? = null

)

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val repository: UserRepository
) : ViewModel(){

    private val _uiState = MutableStateFlow(RegisterUiState())
    val uiState: StateFlow<RegisterUiState> = _uiState

    fun updateEmail(email: String) {
        _uiState.update { it.copy(email = email) }
    }

    fun updatePassword(password: String) {
        _uiState.update { it.copy(password = password) }
    }


    fun register() {

        viewModelScope.launch {

            val email = uiState.value.email
            val password = uiState.value.password

            _uiState.update {
                it.copy(loading = true)
            }

            repository.register(email, password)

            _uiState.update {
                it.copy(
                    loading = false,
                    success = true
                )
            }

        }

    }
}