package com.example.mvpdaggertest.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mvpdaggertest.R
import com.example.mvpdaggertest.data.Data
import kotlinx.android.synthetic.main.detail_fragment.*

class DetailFragment : Fragment(), DetailContract.DetailView {

    override lateinit var presenter: DetailContract.DetailPresenter

    companion object {
        @JvmStatic
        fun newInstance() = DetailFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.detail_fragment, container, false)
    }

    override fun onResume() {
        super.onResume()
        presenter.start()
    }

    override fun showGitData(data: Data) {
        name.text = data.full_name
        url.text = data.git_url
    }
}
