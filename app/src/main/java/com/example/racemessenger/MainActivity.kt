package com.example.racemessenger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.racemessenger.api.RetrofitClient
import com.example.racemessenger.entities.ClientUserData
import com.example.racemessenger.entities.ServerUserData
import com.example.racemessenger.fragments.authorization.AuthorizationFragment
import com.example.racemessenger.fragments.main.MainFragment
import com.example.racemessenger.fragments.message.MessageFragment
import com.example.racemessenger.fragments.receiver.ReceiverFragment
import com.example.racemessenger.fragments.sender.SenderFragment
import retrofit2.Retrofit

class MainActivity : AppCompatActivity(), Communicator {

    private val retrofitClient = RetrofitClient
    private lateinit var retrofit : Retrofit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        retrofit = retrofitClient.getClient()
        setAuthorizationFragment(retrofit)
    }

    private fun setFragment(fragment: Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainerView, fragment)
            .commit()
    }

    override fun setMainFragment(clientUserData: ClientUserData, retrofit : Retrofit) {
        setFragment(MainFragment(clientUserData, retrofit))
    }

    override fun setReceiverFragment(clientUserData: ClientUserData, retrofit : Retrofit) {
        setFragment(ReceiverFragment(clientUserData, retrofit))
    }

    override fun setSenderFragment(clientUserData: ClientUserData, retrofit : Retrofit) {
        setFragment(SenderFragment(clientUserData, retrofit))
    }

    override fun setMessageFragment(clientUserData: ClientUserData, senderLogin : String, retrofit : Retrofit) {
        setFragment(MessageFragment(clientUserData, senderLogin, retrofit))
    }

    override fun setAuthorizationFragment(retrofit : Retrofit) {
        setFragment(AuthorizationFragment(retrofit))
    }
}