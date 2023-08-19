package com.example.racemessenger.fragments.message

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import androidx.core.graphics.alpha
import com.example.racemessenger.R
import com.example.racemessenger.communicator
import com.example.racemessenger.databinding.FragmentMessageBinding
import com.example.racemessenger.entities.ClientUserData
import com.example.racemessenger.fragments.message.interfaces.MessageView
import com.example.racemessenger.fragments.message.presenters.MessageFragmentPresenter
import com.example.racemessenger.fragments.message.threads.GetMessageTask
import com.google.gson.Gson
import com.google.gson.JsonObject
import org.json.JSONObject
import retrofit2.Retrofit
import java.util.Timer
import java.util.TimerTask


class MessageFragment(
    private val clientUserData: ClientUserData,
    private val senderLogin : String,
    private val retrofit: Retrofit
) : Fragment(R.layout.fragment_message), MessageView {

    private lateinit var binding : FragmentMessageBinding
    //there should be a function that checks is this user exist

    private val messageFragmentPresenter = MessageFragmentPresenter(this)
    private val getMessageTask = GetMessageTask(
        senderLogin, messageFragmentPresenter, clientUserData, retrofit)
    private val timer = Timer()

    //there should be a thread that will send a requests to the server with 100ms frequency
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMessageBinding.bind(view)
        init()
    }

    @SuppressLint("SetTextI18n")
    private fun init(){
        timer.schedule(getMessageTask, 500, 500)
        buttonListeners()
        binding.connectedToText.text = "Подключено к: $senderLogin"
    }

    private fun buttonListeners(){
        binding.messageBackBtn.setOnClickListener {
            timer.cancel()
            communicator().setReceiverFragment(clientUserData, retrofit)
        }
    }

    private fun setBackgroundColorBasedOnMessage(message: String){
        when (message) {
            resources.getString(R.string.sender_btn0) -> {
                binding.messageBackground.setBackgroundColor(Color.GREEN)
            }
            resources.getString(R.string.sender_btn1), resources.getString(R.string.sender_btn2), resources.getString(R.string.sender_btn3), resources.getString(R.string.sender_btn4) -> {
                binding.messageBackground.setBackgroundColor(Color.RED)
            }
            resources.getString(R.string.sender_btn5) -> {
                binding.messageBackground.setBackgroundColor(Color.MAGENTA)
            }
            resources.getString(R.string.sender_btn6) -> {
                binding.messageBackground.setBackgroundColor(Color.GREEN)
            }
            resources.getString(R.string.sender_btn7), resources.getString(R.string.sender_btn8) -> {
                binding.messageBackground.setBackgroundColor(Color.BLUE)
            }
            resources.getString(R.string.sender_btn9) -> {
                binding.messageBackground.setBackgroundColor(Color.CYAN)
            }
            resources.getString(R.string.sender_btn10) -> {
                binding.messageBackground.setBackgroundColor(Color.MAGENTA)
            }
            resources.getString(R.string.sender_btn11) -> {
                binding.messageBackground.setBackgroundColor(Color.YELLOW)
            }
            resources.getString(R.string.sender_btn12) -> {
                binding.messageBackground.setBackgroundColor(Color.MAGENTA)
            }
            resources.getString(R.string.sender_btn13) -> {
                binding.messageBackground.setBackgroundColor(Color.MAGENTA)
            }
            resources.getString(R.string.sender_btn14) -> {
                binding.messageBackground.setBackgroundColor(Color.GREEN)
            }
            resources.getString(R.string.sender_btn15) -> {
                binding.messageBackground.setBackgroundColor(Color.RED)
            }
            else -> {
                binding.messageBackground.setBackgroundColor(Color.TRANSPARENT)
            }
        }
    }

    override fun displayMessage(message: String) {
        if (message != ""){
            val gson = Gson()
            val jsonObject = gson.fromJson(message, JsonObject::class.java)
            val data = jsonObject.get("Message").asString
            setBackgroundColorBasedOnMessage(data)
            binding.messageTextview.text = data
        }
    }
}