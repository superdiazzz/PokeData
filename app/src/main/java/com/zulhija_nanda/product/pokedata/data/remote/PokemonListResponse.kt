package com.zulhija_nanda.product.pokedata.data.remote

data class PokemonListResponse(
    val results: List<PokemonItem>
)

data class PokemonItem(
    val name: String,
    val url: String
)