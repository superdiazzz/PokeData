package com.zulhija_nanda.product.pokedata.ui.screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zulhija_nanda.product.pokedata.data.remote.PokemonDetailResponse
import com.zulhija_nanda.product.pokedata.network.ApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel  @Inject constructor(
    private val api: ApiService
): ViewModel(){

    var pokemon by mutableStateOf<PokemonDetailResponse?>(null)
        private set

    fun loadDetail(name: String) {

        viewModelScope.launch {

            pokemon = api.getPokemonDetail(name)

        }

    }

}