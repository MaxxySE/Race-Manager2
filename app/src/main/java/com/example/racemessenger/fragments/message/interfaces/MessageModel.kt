package com.example.racemessenger.fragments.message.interfaces

import com.example.racemessenger.entities.ClientUserData
import retrofit2.Retrofit

interface MessageModel {
    suspend fun startReceivingMessage(senderLogin : String, clientUserData: ClientUserData, retrofit: Retrofit) : String
}