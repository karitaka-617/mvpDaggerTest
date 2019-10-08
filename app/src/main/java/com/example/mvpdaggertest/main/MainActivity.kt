package com.example.mvpdaggertest.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mvpdaggertest.R
import com.example.mvpdaggertest.data.GitRepository
import com.example.mvpdaggertest.util.replaceFragmentInActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainFragment = supportFragmentManager
            .findFragmentById(R.id.contentFrame) as MainFragment?
            ?: MainFragment.newInstance().also {
                replaceFragmentInActivity(it, R.id.contentFrame)
            }

        val gitRepository = GitRepository.getInstance()

        MainPresenter(
            gitRepository, mainFragment
        )
    }
}
