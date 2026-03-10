package com.zulhija_nanda.product.pokedata.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.zulhija_nanda.product.pokedata.data.local.PokemonEntity

@Dao
interface PokemonDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(pokemon: List<PokemonEntity>)


    @Query("SELECT * FROM pokemon LIMIT 10 OFFSET :offset")
    suspend fun getPokemon(offset: Int) : List<PokemonEntity>

}