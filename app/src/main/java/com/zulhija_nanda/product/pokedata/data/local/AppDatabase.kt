package com.zulhija_nanda.product.pokedata.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.zulhija_nanda.product.pokedata.data.local.dao.PokemonDao
import com.zulhija_nanda.product.pokedata.data.local.dao.UserDao

@Database(
    entities = [
        UserEntity::class,
        PokemonEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase(){
    abstract fun userDao() : UserDao

    abstract fun pokemonDao(): PokemonDao

}