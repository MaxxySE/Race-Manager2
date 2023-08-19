package com.example.racemessenger.fragments.message.threads

import com.example.racemessenger.entities.ClientUserData
import com.example.racemessenger.fragments.message.presenters.MessageFragmentPresenter
import retrofit2.Retrofit
import java.util.TimerTask

class GetMessageTask(
    private val senderLogin: String,
    private val messageFragmentPresenter: MessageFragmentPresenter,
    private val clientUserData: ClientUserData,
    private val retrofit: Retrofit
) : TimerTask() {

    override fun run() {
        messageFragmentPresenter.startReceivingMessage(senderLogin, clientUserData, retrofit)
    }
}