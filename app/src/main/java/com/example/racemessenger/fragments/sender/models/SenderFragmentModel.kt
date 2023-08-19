package com.example.racemessenger.fragments.sender.models

import android.content.ContentValues
import android.util.Log
import com.example.racemessenger.api.ApiService
import com.example.racemessenger.entities.ClientUserData
import com.example.racemessenger.entities.LogoutData
import com.example.racemessenger.entities.SendMessageData
import com.example.racemessenger.fragments.sender.interfaces.SenderModel
import retrofit2.HttpException
import retrofit2.Retrofit

class SenderFragmentModel : SenderModel {

    private lateinit var sendMessageData: SendMessageData

    override suspend fun sendMessage(clientUserData: ClientUserData, message: String, retrofit: Retrofit) {
        sendMessageData = SendMessageData(
            token = clientUserData.token,
            data = message
        )

        val apiService = retrofit.create(ApiService::class.java)

        try {
            apiService.sendData(sendMessageData)

        } catch (e: HttpException) {
            if (e.code() == 500) {
                Log.e(ContentValues.TAG, "Server error")
            }
            if (e.code() == 200) {
                println("Success")
            }else {
                Log.e(ContentValues.TAG, "HTTP error: ${e.code()}")
            }
        } catch (e: Exception) {
            Log.e(ContentValues.TAG, "Error: ${e.message}")
        }

        println(clientUserData.login + " " + clientUserData.token + " " + message)
    }
}