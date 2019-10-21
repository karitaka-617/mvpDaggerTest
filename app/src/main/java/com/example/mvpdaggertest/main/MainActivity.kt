package com.example.mvpdaggertest.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mvpdaggertest.CustomApplication
import com.example.mvpdaggertest.R
import com.example.mvpdaggertest.data.GitRepository
import com.example.mvpdaggertest.detail.DetailActivity
import com.example.mvpdaggertest.util.replaceFragmentInActivity
import javax.inject.Inject

class MainActivity :
    AppCompatActivity(),
    MainFragment.OnFragmentInteractionListener
{
    lateinit var gitRepository: GitRepository
    @Inject lateinit var mainFragment: MainFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as? CustomApplication)!!.appComponent
            .plus(MainActivityModule())
            .inject(this)

        gitRepository = (application as? CustomApplication)!!.gitRepository

        replaceFragmentInActivity(mainFragment,R.id.contentFrame)

        MainPresenter(
            gitRepository, mainFragment
        )
    }

    override fun onStartMain2(projectName: String) {
        val intent = Intent(this@MainActivity, DetailActivity::class.java)
        intent.putExtra("projectName",projectName)
        startActivity(intent)
    }
}
