package com.example.racemessenger.fragments.sender.presenters

import com.example.racemessenger.entities.ClientUserData
import com.example.racemessenger.fragments.sender.interfaces.SenderPresenter
import com.example.racemessenger.fragments.sender.interfaces.SenderView
import com.example.racemessenger.fragments.sender.models.SenderFragmentModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit

class SenderFragmentPresenter(
    private val senderView: SenderView
    ) : SenderPresenter {

    private val senderFragmentModel = SenderFragmentModel()

    override fun sendMessage(clientUserData: ClientUserData, message: String, retrofit: Retrofit) {
        CoroutineScope(Dispatchers.IO).launch {
            senderFragmentModel.sendMessage(clientUserData, message, retrofit)
        }
    }
}