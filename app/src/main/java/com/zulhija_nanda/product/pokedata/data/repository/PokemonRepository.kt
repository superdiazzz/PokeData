package com.zulhija_nanda.product.pokedata.data.repository

import com.zulhija_nanda.product.pokedata.data.local.dao.PokemonDao
import com.zulhija_nanda.product.pokedata.network.ApiService

class PokemonRepository(
    private val api: ApiService,
    private val dao: PokemonDao
) {



}