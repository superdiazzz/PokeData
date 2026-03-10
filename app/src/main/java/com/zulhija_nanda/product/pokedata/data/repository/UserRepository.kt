package com.zulhija_nanda.product.pokedata.data.repository

import com.zulhija_nanda.product.pokedata.data.local.UserEntity
import com.zulhija_nanda.product.pokedata.data.local.dao.UserDao
import javax.inject.Inject

class UserRepository @Inject constructor(private val userDao: UserDao) {

    suspend fun register(
        email: String,
        password: String
    ){
        userDao.insertUser(
            UserEntity(
                email = email,
                password = password
            )
        )
    }

    suspend fun login(
        email: String,
        password: String
    ): UserEntity? {
        return userDao.login(email, password)
    }
}