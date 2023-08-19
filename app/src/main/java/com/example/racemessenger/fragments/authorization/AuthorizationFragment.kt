package com.example.racemessenger.fragments.authorization

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.example.racemessenger.R
import com.example.racemessenger.communicator
import com.example.racemessenger.databinding.FragmentAuthorizationBinding
import com.example.racemessenger.entities.ClientUserData
import com.example.racemessenger.entities.ServerUserData
import com.example.racemessenger.fragments.authorization.interfaces.AuthView
import com.example.racemessenger.fragments.authorization.presenters.AuthFragmentPresenter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import java.util.*


class AuthorizationFragment(
    private val retrofit: Retrofit
) : Fragment(R.layout.fragment_authorization), AuthView {

    private lateinit var binding: FragmentAuthorizationBinding
    private var serverUserData = ServerUserData()

    private val authFragmentPresenter = AuthFragmentPresenter(this)
    private val timer = Timer()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAuthorizationBinding.bind(view)
        init()
    }

    private fun init(){
        buttonListeners()
    }

    private fun buttonListeners(){
        binding.signinBtn.setOnClickListener {
            signin()
        }

        binding.signupBtn.setOnClickListener {
            signup()
        }
    }

    private fun signin(){
        serverUserData = ServerUserData(
            login = binding.loginTextfield.text.toString(),
            password = binding.passwordTextfield.text.toString()
        )
        if(serverUserData.login != "" && serverUserData.password != "") {
            authFragmentPresenter.signinUser(serverUserData, retrofit)

        } else {
            binding.errorAuthText.visibility = View.VISIBLE
            binding.errorAuthText.text = getString(R.string.something_missed)
        }
    }

    private fun signup(){
        serverUserData = ServerUserData(
            login = binding.loginTextfield.text.toString(),
            password = binding.passwordTextfield.text.toString()
        )
        if(serverUserData.login != "" && serverUserData.password != "") {
            authFragmentPresenter.signupUser(serverUserData, retrofit)

        } else {
            binding.errorAuthText.visibility = View.VISIBLE
            binding.errorAuthText.text = getString(R.string.something_missed)
        }
    }

    override fun signinUser(clientUserData: ClientUserData) {
        if(clientUserData.token != ""){
            communicator().setMainFragment(clientUserData, retrofit)
        } else {
            binding.errorAuthText.visibility = View.VISIBLE
            binding.errorAuthText.text = getString(R.string.wrong_data)

        }
    }

    override fun signupUser(clientUserData: ClientUserData) {
        if(clientUserData.token != ""){
            communicator().setMainFragment(clientUserData, retrofit)
        } else {
            binding.errorAuthText.visibility = View.VISIBLE
            binding.errorAuthText.text = getString(R.string.login_restricted)
        }
    }

}