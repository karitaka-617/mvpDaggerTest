package com.example.mvpdaggertest.main

import com.example.mvpdaggertest.BasePresenter
import com.example.mvpdaggertest.BaseView
import com.example.mvpdaggertest.data.Data

interface MainContract {
    interface MainView : BaseView<MainPresenter> {
        fun showGitData(data: List<Data>)
    }
    interface MainPresenter : BasePresenter {

    }
}