package com.zulhija_nanda.product.pokedata.di

import android.content.Context
import androidx.room.Room
import com.zulhija_nanda.product.pokedata.data.local.AppDatabase
import com.zulhija_nanda.product.pokedata.data.local.dao.PokemonDao
import com.zulhija_nanda.product.pokedata.data.local.dao.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ) : AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "app_db"
        ).build()
    }

    @Provides
    fun provideUserDao(db: AppDatabase): UserDao {
        return db.userDao()
    }

    @Provides
    fun providePokemonDao(db: AppDatabase) : PokemonDao {
        return db.pokemonDao()
    }
}