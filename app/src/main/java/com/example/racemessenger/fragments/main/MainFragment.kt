package com.example.racemessenger.fragments.main

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.racemessenger.R
import com.example.racemessenger.communicator
import com.example.racemessenger.databinding.FragmentMainBinding
import com.example.racemessenger.entities.ClientUserData
import com.example.racemessenger.entities.ServerUserData
import com.example.racemessenger.fragments.main.interfaces.MainView
import com.example.racemessenger.fragments.main.presenters.MainFragmentPresenter
import retrofit2.Retrofit


class MainFragment(
    private val clientUserData: ClientUserData,
    private val retrofit: Retrofit
) : Fragment(R.layout.fragment_main), MainView {

    private lateinit var binding: FragmentMainBinding

    private val mainFragmentPresenter = MainFragmentPresenter(this)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainBinding.bind(view)
        init()
    }

    private fun init(){
        buttonListeners()
        setVariables()
    }

    @SuppressLint("SetTextI18n")
    private fun setVariables(){
        binding.loginTextview.text =
            getText(R.string.your_login_is).toString() + " " +
                    clientUserData.login
    }

    private fun buttonListeners(){
        binding.receiveBtn.setOnClickListener {
            communicator().setReceiverFragment(clientUserData, retrofit)
        }

        binding.sendBtn.setOnClickListener {
            communicator().setSenderFragment(clientUserData, retrofit)
        }

        binding.logoutBtn.setOnClickListener {
            mainFragmentPresenter.logoutUser(clientUserData, retrofit)
        }
    }

    override fun logoutUser() {
        communicator().setAuthorizationFragment(retrofit)
    }
}