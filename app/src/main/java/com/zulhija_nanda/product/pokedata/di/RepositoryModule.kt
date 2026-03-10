package com.zulhija_nanda.product.pokedata.di

import com.zulhija_nanda.product.pokedata.data.local.dao.PokemonDao
import com.zulhija_nanda.product.pokedata.data.local.dao.UserDao
import com.zulhija_nanda.product.pokedata.data.repository.PokemonRepository
import com.zulhija_nanda.product.pokedata.data.repository.UserRepository
import com.zulhija_nanda.product.pokedata.network.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun providePokemonRepository(
        api: ApiService,
        dao: PokemonDao
    ): PokemonRepository{
        return PokemonRepository(api, dao)
    }

    @Provides
    fun provideUserRepository(
        dao: UserDao
    ) : UserRepository {
        return UserRepository(dao)
    }
}