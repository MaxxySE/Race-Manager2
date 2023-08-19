package com.example.racemessenger.api

import com.example.racemessenger.entities.AuthResponse
import com.example.racemessenger.entities.ClientUserData
import com.example.racemessenger.entities.DataResponse
import com.example.racemessenger.entities.LogoutData
import com.example.racemessenger.entities.ReceiveMessageData
import com.example.racemessenger.entities.SendMessageData
import com.example.racemessenger.entities.ServerUserData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @POST("register")
    suspend fun registerUser(@Body serverUserData: ServerUserData) : AuthResponse

    @POST("login")
    suspend fun loginUser(@Body serverUserData: ServerUserData) : AuthResponse

    @POST("logout")
    suspend fun logoutUser(@Body logoutData: LogoutData)

    @POST("send")
    suspend fun sendData(@Body sendMessageData: SendMessageData)

    @POST("get-last")
    suspend fun getMessage(@Body receiveMessageData: ReceiveMessageData) : DataResponse
}