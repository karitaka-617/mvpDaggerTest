package com.example.mvpdaggertest.detail

import com.example.mvpdaggertest.BasePresenter
import com.example.mvpdaggertest.BaseView
import com.example.mvpdaggertest.data.Data

interface DetailContract {
    interface DetailView : BaseView<DetailPresenter> {
        fun showGitData(data: Data)
    }
    interface DetailPresenter : BasePresenter {}
}