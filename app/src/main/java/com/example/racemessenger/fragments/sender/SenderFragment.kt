package com.example.racemessenger.fragments.sender

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.racemessenger.R
import com.example.racemessenger.communicator
import com.example.racemessenger.databinding.FragmentSenderBinding
import com.example.racemessenger.entities.ClientUserData
import com.example.racemessenger.fragments.sender.interfaces.SenderView
import com.example.racemessenger.fragments.sender.presenters.SenderFragmentPresenter
import retrofit2.Retrofit
import kotlin.concurrent.thread


class SenderFragment(
    private val clientUserData: ClientUserData,
    private val retrofit: Retrofit
) : Fragment(R.layout.fragment_sender), SenderView {

    private lateinit var binding : FragmentSenderBinding

    private val senderFragmentPresenter = SenderFragmentPresenter(this)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSenderBinding.bind(view)
        init()
    }



    private fun init(){
        buttonListeners()
    }

    private fun buttonListeners(){
        binding.senderBackBtn.setOnClickListener {
            communicator().setMainFragment(clientUserData, retrofit)
        }



        binding.senderBtn0.setOnClickListener { sendMessage(binding.senderBtn0.text.toString()) }
        binding.senderBtn1.setOnClickListener { sendMessage(binding.senderBtn1.text.toString())  }
        binding.senderBtn2.setOnClickListener { sendMessage(binding.senderBtn2.text.toString())  }
        binding.senderBtn3.setOnClickListener { sendMessage(binding.senderBtn3.text.toString())  }
        binding.senderBtn4.setOnClickListener { sendMessage(binding.senderBtn4.text.toString())  }
        binding.senderBtn5.setOnClickListener { sendMessage(binding.senderBtn5.text.toString())  }
        binding.senderBtn6.setOnClickListener { sendMessage(binding.senderBtn6.text.toString())  }
        binding.senderBtn7.setOnClickListener { sendMessage(binding.senderBtn7.text.toString())  }
        binding.senderBtn8.setOnClickListener { sendMessage(binding.senderBtn8.text.toString())  }
        binding.senderBtn9.setOnClickListener { sendMessage(binding.senderBtn9.text.toString())  }
        binding.senderBtn10.setOnClickListener { sendMessage(binding.senderBtn10.text.toString())  }
        binding.senderBtn11.setOnClickListener { sendMessage(binding.senderBtn11.text.toString())  }
        binding.senderBtn12.setOnClickListener { sendMessage(binding.senderBtn12.text.toString())  }
        binding.senderBtn13.setOnClickListener { sendMessage(binding.senderBtn13.text.toString())  }
        binding.senderBtn14.setOnClickListener { sendMessage(binding.senderBtn14.text.toString())  }
        binding.senderBtn15.setOnClickListener { sendMessage(binding.senderBtn15.text.toString())  }

        binding.sendMessageBtn.setOnClickListener {
            sendMessage(binding.messageTextfield.text.toString())
            binding.messageTextfield.setText("")
        }

    }

    @SuppressLint("SetTextI18n")
    private fun sendMessage(message : String){
        senderFragmentPresenter.sendMessage(clientUserData, message, retrofit)
        binding.messageSentTextview.setText("Сообщение: '$message' отправлено!")
        binding.messageSentTextview.visibility = View.VISIBLE
    }

}