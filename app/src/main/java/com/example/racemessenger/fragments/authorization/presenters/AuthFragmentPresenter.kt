package com.example.racemessenger.fragments.authorization.presenters

import com.example.racemessenger.entities.ServerUserData
import com.example.racemessenger.fragments.authorization.interfaces.AuthPresenter
import com.example.racemessenger.fragments.authorization.interfaces.AuthView
import com.example.racemessenger.fragments.authorization.models.AuthFragmentModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit

class AuthFragmentPresenter(
    private val authView: AuthView
) : AuthPresenter {

    private val authFragmentModel = AuthFragmentModel()

    override fun signinUser(serverUserData: ServerUserData, retrofit: Retrofit) {
        CoroutineScope(Dispatchers.IO).launch {
            withContext(Dispatchers.Main){
                authView.signinUser(authFragmentModel.signinUser(serverUserData, retrofit))
            }
        }

    }

    override fun signupUser(serverUserData: ServerUserData, retrofit: Retrofit) {
        CoroutineScope(Dispatchers.IO).launch {
            withContext(Dispatchers.Main){
                authView.signupUser(authFragmentModel.signupUser(serverUserData, retrofit))
            }
        }
    }
}