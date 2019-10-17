package com.example.mvpdaggertest.main

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mvpdaggertest.R
import com.example.mvpdaggertest.data.Data
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment(), MainContract.MainView {

    private var listener: OnFragmentInteractionListener? = null

    private lateinit var mAdapter: MainAdapter
    override lateinit var presenter: MainContract.MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onResume() {
        super.onResume()
        presenter.start()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(" must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    override fun showGitData(data: List<Data>) {
        //取得した内容をRecyclerViewに表示
            recycler_view.layoutManager = GridLayoutManager(context,2)
            mAdapter = MainAdapter(context!!, data, listener!!)
            recycler_view.adapter = mAdapter
    }

    interface OnFragmentInteractionListener {
        fun onStartMain2()
    }

    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
    }
}
