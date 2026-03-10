package com.zulhija_nanda.product.pokedata.network

import com.zulhija_nanda.product.pokedata.data.remote.PokemonDetailResponse
import com.zulhija_nanda.product.pokedata.data.remote.PokemonListResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("limit") limit:Int = 10,
        @Query("offset") offset:Int
    ): PokemonListResponse


    @GET("pokemon/{name}")
    suspend fun getPokemonDetail(
        @Path("name") name:String
    ): PokemonDetailResponse
}