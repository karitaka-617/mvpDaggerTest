package com.example.mvpdaggertest.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mvpdaggertest.CustomApplication
import com.example.mvpdaggertest.R
import com.example.mvpdaggertest.data.GitRepository
import com.example.mvpdaggertest.gitdata.MainActivity2
import com.example.mvpdaggertest.util.replaceFragmentInActivity
import javax.inject.Inject

class MainActivity :
    AppCompatActivity(),
    MainFragment.OnFragmentInteractionListener
{
    @Inject lateinit var gitRepository: GitRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainFragment = supportFragmentManager
            .findFragmentById(R.id.contentFrame) as MainFragment?
            ?: MainFragment.newInstance().also {
                replaceFragmentInActivity(it, R.id.contentFrame)
            }

        val app = (application as? CustomApplication)?.appComponent
        val actComponent = app!!.plus(MainActivityModule())
        actComponent.inject(this)

        MainPresenter(
            gitRepository, mainFragment
        )
    }

    override fun onStartMain2() {
        val intent = Intent(this@MainActivity, MainActivity2::class.java)
        startActivity(intent)
    }
}
