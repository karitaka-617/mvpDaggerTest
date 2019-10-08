package com.example.mvpdaggertest.main

import com.example.mvpdaggertest.data.GitRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainPresenter(
    private val gitRepository: GitRepository,
    private val mainView: MainContract.MainView
): MainContract.MainPresenter {

    init {
        //Presenterを指定
        mainView.presenter = this
    }

    override fun start() {
        getGitListData()
    }

    private fun getGitListData(){
        // githubのリポジトリ一覧を取得
        GlobalScope.launch(Dispatchers.Main){
            val gitList = gitRepository.getGitListData("sample")

            mainView.showGitData(gitList)
        }
    }
}