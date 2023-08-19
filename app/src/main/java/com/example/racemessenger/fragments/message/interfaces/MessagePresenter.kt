package com.example.racemessenger.fragments.message.interfaces

import com.example.racemessenger.entities.ClientUserData
import retrofit2.Retrofit

interface MessagePresenter {
    fun startReceivingMessage(senderLogin : String, clientUserData: ClientUserData, retrofit: Retrofit)
}