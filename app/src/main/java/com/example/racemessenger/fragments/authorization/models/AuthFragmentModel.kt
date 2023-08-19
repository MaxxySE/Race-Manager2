package com.example.racemessenger.fragments.authorization.models

import android.content.ContentValues.TAG
import android.util.Log
import com.example.racemessenger.api.ApiService
import com.example.racemessenger.api.RetrofitClient
import com.example.racemessenger.entities.AuthResponse
import com.example.racemessenger.entities.ClientUserData
import com.example.racemessenger.entities.ServerUserData
import com.example.racemessenger.fragments.authorization.interfaces.AuthModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.create

class AuthFragmentModel : AuthModel {

    private var clientUserData = ClientUserData()
    private var token = ""

    override suspend fun signinUser(
        serverUserData: ServerUserData, retrofit: Retrofit
    ): ClientUserData {
        //There should be a function that sending requests on the server with DB and it should return a token

        val apiService = retrofit.create(ApiService::class.java)

        try {
            val authResponse = apiService.loginUser(serverUserData)

            clientUserData = ClientUserData(
                login = serverUserData.login,
                token = authResponse.token
            )

            return clientUserData

        } catch (e: HttpException) {
            if (e.code() == 500) {
                Log.e(TAG, "Server error")
            } else {
                Log.e(TAG, "HTTP error: ${e.code()}")
            }
        } catch (e: Exception) {
            Log.e(TAG, "Error: ${e.message}")
        }
        return clientUserData
    }

    override suspend fun signupUser(serverUserData: ServerUserData, retrofit: Retrofit): ClientUserData {

        val apiService = retrofit.create(ApiService::class.java)

        try {
            val authResponse = apiService.registerUser(serverUserData)

            clientUserData = ClientUserData(
                login = serverUserData.login,
                token = authResponse.token
            )

            return clientUserData

        } catch (e: HttpException) {
            if (e.code() == 500) {
                Log.e(TAG, "Server error")
            } else {
                Log.e(TAG, "HTTP error: ${e.code()}")
            }
        } catch (e: Exception) {
            Log.e(TAG, "Error: ${e.message}")
        }
        return clientUserData
    }

}