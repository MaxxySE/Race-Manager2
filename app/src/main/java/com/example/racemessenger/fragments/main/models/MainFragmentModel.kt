package com.example.racemessenger.fragments.main.models

import android.content.ContentValues
import android.util.Log
import com.example.racemessenger.api.ApiService
import com.example.racemessenger.entities.ClientUserData
import com.example.racemessenger.entities.LogoutData
import com.example.racemessenger.fragments.main.interfaces.MainModel
import retrofit2.HttpException
import retrofit2.Retrofit
import kotlin.math.log

class MainFragmentModel : MainModel {

    private lateinit var logoutData : LogoutData

    override suspend fun logoutUser(clientUserData: ClientUserData, retrofit: Retrofit) {

        logoutData = LogoutData(
            token = clientUserData.token
        )

        val apiService = retrofit.create(ApiService::class.java)

        try {

            apiService.logoutUser(logoutData)

        } catch (e: HttpException) {
            if (e.code() == 500) {
                Log.e(ContentValues.TAG, "Server error")
            } else {
                Log.e(ContentValues.TAG, "HTTP error: ${e.code()}")
            }
        } catch (e: Exception) {
            Log.e(ContentValues.TAG, "Error: ${e.message}")
        }

    }
}