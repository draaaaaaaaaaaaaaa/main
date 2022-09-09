package com.daffa.news_main.componen.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.daffa.news_main.databinding.ItemRowNewsBinding
import com.daffa.news_main.network.response.MainResponseItem

class MainAdapter(private val MainList: List<MainResponseItem>) :
    RecyclerView.Adapter<MainAdapter.MyViewHolder>() {
    class MyViewHolder(val binding: ItemRowNewsBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyViewHolder (
        ItemRowNewsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
    )

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = MainList[position]
        holder.binding.apply {
            tvCategory.text = data.tag
            tvTitle.text = data.title
            tvDate.text = data.time
            Glide.with(imgNews.context)
                .load(data.thumb)
                .into(imgNews)
        }
    }

    override fun getItemCount(): Int = MainList.size
}