package com.zulhija_nanda.product.pokedata.data.repository

import com.zulhija_nanda.product.pokedata.data.local.PokemonEntity
import com.zulhija_nanda.product.pokedata.data.local.dao.PokemonDao
import com.zulhija_nanda.product.pokedata.network.ApiService
import javax.inject.Inject

class PokemonRepository @Inject constructor(
    private val api: ApiService,
    private val dao: PokemonDao
) {

    suspend fun getPokemon(offset:Int):List<PokemonEntity>{

        return try {

            val response = api.getPokemonList(offset = offset)

            val list = response.results.map {
                PokemonEntity(it.name)
            }

            dao.insertAll(list)

            list

        }catch (e:Exception){

            dao.getPokemon(offset)

        }

    }

}