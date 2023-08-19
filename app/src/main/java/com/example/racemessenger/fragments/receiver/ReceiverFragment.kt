package com.example.racemessenger.fragments.receiver

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.racemessenger.R
import com.example.racemessenger.communicator
import com.example.racemessenger.databinding.FragmentReceiverBinding
import com.example.racemessenger.entities.ClientUserData
import retrofit2.Retrofit


class ReceiverFragment(
    private val clientUserData: ClientUserData,
    private val retrofit: Retrofit
) : Fragment(R.layout.fragment_receiver) {

    private lateinit var binding: FragmentReceiverBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentReceiverBinding.bind(view)
        init()
    }

    private fun init(){
        buttonListeners()
    }

    private fun buttonListeners(){
        binding.receiverBackBtn.setOnClickListener {
            communicator().setMainFragment(clientUserData, retrofit)
        }

        binding.connectBtn.setOnClickListener {
            communicator().setMessageFragment(
                clientUserData,
                senderLogin = binding.managerLoginTextfield.text.toString(),
                retrofit
            )
        }
    }

}