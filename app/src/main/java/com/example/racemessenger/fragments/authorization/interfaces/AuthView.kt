package com.example.racemessenger.fragments.authorization.interfaces

import com.example.racemessenger.entities.ClientUserData

interface AuthView {
    fun signinUser(clientUserData: ClientUserData)
    fun signupUser(clientUserData: ClientUserData)
}