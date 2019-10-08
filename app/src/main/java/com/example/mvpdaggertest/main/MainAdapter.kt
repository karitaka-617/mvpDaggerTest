package com.example.mvpdaggertest.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvpdaggertest.R
import com.example.mvpdaggertest.data.Data
import kotlinx.android.synthetic.main.git_item_list.view.*

class MainAdapter(context: Context, data: List<Data>): RecyclerView.Adapter<RecyclerView.ViewHolder>()  {
    private var mInflater: LayoutInflater = LayoutInflater.from(context)
    private var mData: List<Data> = data
    //    private var mContext: Context = context
//    private var mListener: OnRecyclerListener = listener

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): RecyclerView.ViewHolder {
        // 表示するレイアウトを設定
        return ViewHolder(mInflater.inflate(R.layout.git_item_list, viewGroup, false))
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, i: Int) {
        // データ表示
        if (mData.size > i) {
            viewHolder.itemView.list_item_text.text = mData[i].name
        }

        // クリック処理
        viewHolder.itemView.list_liner.setOnClickListener { _ ->
//            mListener.onRecyclerClicked(v, viewHolder.layoutPosition,mData[i].owner.login,mData[i].name)
        }
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    // ViewHolder(固有ならインナークラスでOK)
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        var textView: TextView = itemView.findViewById(R.id.list_item_text)
    }
}