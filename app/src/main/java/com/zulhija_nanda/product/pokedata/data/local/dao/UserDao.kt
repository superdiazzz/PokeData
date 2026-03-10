package com.zulhija_nanda.product.pokedata.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.zulhija_nanda.product.pokedata.data.local.UserEntity

@Dao
interface UserDao {

    @Insert
    suspend fun insertUser(user: UserEntity)


    @Query("SELECT * FROM users WHERE email=:email AND password=:password")
    suspend fun login(email: String, password: String) : UserEntity?

    @Query("SELECT * FROM users WHERE email = :email")
    suspend fun getUser(email: String): UserEntity?
}