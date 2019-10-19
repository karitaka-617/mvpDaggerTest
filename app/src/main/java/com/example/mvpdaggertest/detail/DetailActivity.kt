package com.example.mvpdaggertest.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mvpdaggertest.CustomApplication
import com.example.mvpdaggertest.R
import com.example.mvpdaggertest.data.GitRepository
import com.example.mvpdaggertest.util.replaceFragmentInActivity
import javax.inject.Inject

class DetailActivity : AppCompatActivity() {

    @Inject lateinit var gitRepository: GitRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_activity)

        val intent = intent.getStringExtra("projectName")

        val detailFragment = supportFragmentManager
            .findFragmentById(R.id.container) as DetailFragment?
            ?: DetailFragment.newInstance().also {
                replaceFragmentInActivity(it, R.id.container)
            }

        val app = (application as? CustomApplication)?.appComponent
        val component = app!!.plus(DetailActivityModule())
        component.inject(this)

        DetailPresenter(gitRepository,detailFragment,intent!!)
    }

}
