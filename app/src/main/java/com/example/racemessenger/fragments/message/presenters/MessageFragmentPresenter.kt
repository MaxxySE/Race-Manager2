package com.example.racemessenger.fragments.message.presenters

import com.example.racemessenger.entities.ClientUserData
import com.example.racemessenger.fragments.message.interfaces.MessagePresenter
import com.example.racemessenger.fragments.message.interfaces.MessageView
import com.example.racemessenger.fragments.message.models.MessageFragmentModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit

class MessageFragmentPresenter(
    private val messageView: MessageView
) : MessagePresenter {

    private val messageFragmentModel = MessageFragmentModel()

    override fun startReceivingMessage(
        senderLogin: String,
        clientUserData: ClientUserData,
        retrofit: Retrofit
    ) {
        CoroutineScope(Dispatchers.IO).launch {
            withContext(Dispatchers.Main) {
                messageView.displayMessage(
                    messageFragmentModel.startReceivingMessage(
                        senderLogin,
                        clientUserData,
                        retrofit
                    )
                )
            }
        }
    }
}