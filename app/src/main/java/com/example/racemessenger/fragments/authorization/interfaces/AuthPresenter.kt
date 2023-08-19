package com.example.racemessenger.fragments.authorization.interfaces

import com.example.racemessenger.entities.ServerUserData
import retrofit2.Retrofit

interface AuthPresenter {
    fun signinUser(serverUserData: ServerUserData, retrofit: Retrofit)
    fun signupUser(serverUserData: ServerUserData, retrofit: Retrofit)
}