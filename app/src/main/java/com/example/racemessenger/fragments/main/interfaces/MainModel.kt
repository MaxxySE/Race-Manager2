package com.example.racemessenger.fragments.main.interfaces

import com.example.racemessenger.entities.ClientUserData
import retrofit2.Retrofit

interface MainModel {
    suspend fun logoutUser(clientUserData: ClientUserData, retrofit: Retrofit)
}