package com.example.mvpdaggertest.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mvpdaggertest.CustomApplication
import com.example.mvpdaggertest.R
import com.example.mvpdaggertest.data.GitRepository
import com.example.mvpdaggertest.util.replaceFragmentInActivity
import javax.inject.Inject

class DetailActivity : AppCompatActivity() {

    lateinit var gitRepository: GitRepository
    @Inject lateinit var detailFragment: DetailFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_activity)

        val intent = intent.getStringExtra("projectName")

        (application as? CustomApplication)!!.appComponent
            .plus(DetailActivityModule())
            .inject(this)

        gitRepository = (application as? CustomApplication)!!.gitRepository

        replaceFragmentInActivity(detailFragment, R.id.container)
        DetailPresenter(gitRepository,detailFragment,intent!!)
    }

}
