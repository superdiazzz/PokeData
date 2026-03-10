package com.zulhija_nanda.product.pokedata.network

import retrofit2.http.GET

interface ApiService {

    @GET("pokemon")
    suspend fun getPokemonList()
}