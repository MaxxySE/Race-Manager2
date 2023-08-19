package com.example.racemessenger

import androidx.fragment.app.Fragment
import com.example.racemessenger.entities.ClientUserData
import com.example.racemessenger.entities.ServerUserData
import retrofit2.Retrofit

fun Fragment.communicator() : Communicator {
    return requireActivity() as Communicator
}

interface Communicator {
    fun setMainFragment(clientUserData: ClientUserData, retrofit : Retrofit)
    fun setReceiverFragment(clientUserData: ClientUserData, retrofit : Retrofit)
    fun setSenderFragment(clientUserData: ClientUserData, retrofit : Retrofit)
    fun setMessageFragment(clientUserData: ClientUserData, senderLogin : String, retrofit : Retrofit)
    fun setAuthorizationFragment(retrofit : Retrofit)
}