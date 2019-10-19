package com.example.mvpdaggertest.detail

import com.example.mvpdaggertest.data.GitRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class DetailPresenter(
    private val gitRepository: GitRepository,
    private val detailView: DetailContract.DetailView,
    private val projectName: String
): DetailContract.DetailPresenter{

    init {
        detailView.presenter = this
    }

    override fun start() {
        getGitListData(projectName)
    }

    private fun getGitListData(projectName: String){
        // githubのリポジトリ一覧を取得
        GlobalScope.launch(Dispatchers.Main){
            val gitList = gitRepository.getGitData("sample",projectName)

            detailView.showGitData(gitList)
        }
    }
}