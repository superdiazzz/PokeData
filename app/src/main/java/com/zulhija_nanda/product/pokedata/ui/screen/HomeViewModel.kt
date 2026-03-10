package com.zulhija_nanda.product.pokedata.ui.screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zulhija_nanda.product.pokedata.data.local.PokemonEntity
import com.zulhija_nanda.product.pokedata.data.repository.PokemonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: PokemonRepository
) : ViewModel(){

    var pokemonList = mutableStateListOf<PokemonEntity>()
        private set

    private var offset = 0

    var loading by mutableStateOf(false)

    init {
        loadMore()
    }

    fun loadMore() {

        if (loading) return

        viewModelScope.launch {

            loading = true

            val result = repository.getPokemon(offset)

            pokemonList.addAll(result)

            offset += 10

            loading = false

        }

    }

}