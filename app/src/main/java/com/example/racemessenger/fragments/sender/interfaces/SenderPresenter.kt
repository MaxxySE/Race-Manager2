package com.example.racemessenger.fragments.sender.interfaces

import com.example.racemessenger.entities.ClientUserData
import retrofit2.Retrofit

interface SenderPresenter {
    fun sendMessage(clientUserData: ClientUserData, message : String, retrofit: Retrofit)
}