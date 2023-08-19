package com.example.racemessenger.fragments.main.presenters

import com.example.racemessenger.entities.ClientUserData
import com.example.racemessenger.fragments.main.interfaces.MainPresenter
import com.example.racemessenger.fragments.main.interfaces.MainView
import com.example.racemessenger.fragments.main.models.MainFragmentModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit

class MainFragmentPresenter(
    private val mainView: MainView
) : MainPresenter {

    private val mainFragmentModel = MainFragmentModel()

    override fun logoutUser(clientUserData: ClientUserData, retrofit: Retrofit) {
        CoroutineScope(Dispatchers.IO).launch {
            mainFragmentModel.logoutUser(clientUserData, retrofit)
        }
        mainView.logoutUser()
    }
}