package com.zulhija_nanda.product.pokedata.ui.screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zulhija_nanda.product.pokedata.data.remote.PokemonDetailResponse
import com.zulhija_nanda.product.pokedata.network.ApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class DetailUiState(
    val isLoading: Boolean = false,
    val pokemon: PokemonDetailResponse? = null
)

@HiltViewModel
class DetailViewModel  @Inject constructor(
    private val api: ApiService
): ViewModel(){

    private val _uiState = MutableStateFlow(DetailUiState())
    val uiState = _uiState.asStateFlow()

    fun getPokemon(name: String) {

        viewModelScope.launch {

            _uiState.update { it.copy(isLoading = true) }

            val result = api.getPokemonDetail(name)

            _uiState.update {
                it.copy(
                    isLoading = false,
                    pokemon = result
                )
            }

        }

    }

}