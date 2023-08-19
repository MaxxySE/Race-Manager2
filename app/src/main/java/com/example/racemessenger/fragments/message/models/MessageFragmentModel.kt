package com.example.racemessenger.fragments.message.models

import android.content.ContentValues
import android.util.Log
import com.example.racemessenger.api.ApiService
import com.example.racemessenger.entities.ClientUserData
import com.example.racemessenger.entities.ReceiveMessageData
import com.example.racemessenger.fragments.message.interfaces.MessageModel
import com.google.gson.Gson
import com.google.gson.JsonObject
import org.json.JSONObject
import retrofit2.HttpException
import retrofit2.Retrofit

class MessageFragmentModel : MessageModel {

    private var message = ""
    private lateinit var receiveMessageData : ReceiveMessageData

    override suspend fun startReceivingMessage(
        senderLogin: String,
        clientUserData: ClientUserData,
        retrofit: Retrofit
    ): String {


        receiveMessageData = ReceiveMessageData(
            login = senderLogin,
            token = clientUserData.token
        )
        val apiService = retrofit.create(ApiService::class.java)

        try {
            val dataResponse = apiService.getMessage(receiveMessageData)

            message = dataResponse.data.toString()

            return message

        } catch (e: HttpException) {
            if (e.code() == 500) {
                Log.e(ContentValues.TAG, "Server error")
            } else {
                Log.e(ContentValues.TAG, "HTTP error: ${e.code()}")
            }
        } catch (e: Exception) {
            Log.e(ContentValues.TAG, "Error: ${e.message}")
        }
        return message
    }

}