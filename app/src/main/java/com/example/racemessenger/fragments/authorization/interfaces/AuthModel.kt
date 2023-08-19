package com.example.racemessenger.fragments.authorization.interfaces

import com.example.racemessenger.entities.ClientUserData
import com.example.racemessenger.entities.ServerUserData
import retrofit2.Retrofit

interface AuthModel {
    suspend fun signinUser(serverUserData: ServerUserData, retrofit: Retrofit) : ClientUserData
    suspend fun signupUser(serverUserData: ServerUserData, retrofit: Retrofit) : ClientUserData
}