package com.denbofa.tourdelta.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.denbofa.tourdelta.databinding.SiteItemBinding
import com.denbofa.tourdelta.model.SiteModel
import com.squareup.picasso.Picasso

class SiteAdapter(var lists: List<SiteModel>): RecyclerView.Adapter<SiteAdapter.SiteViewHolder>() {

    inner  class SiteViewHolder(val binding: SiteItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(list: SiteModel){
            Picasso.get().load(list.url).into(binding.image)
            binding.title.text = list.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SiteViewHolder {
        val binding: SiteItemBinding = SiteItemBinding.inflate(LayoutInflater.from(parent.context))
        return SiteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SiteViewHolder, position: Int) {
        val singleSite = lists.get(position)
        holder.bind(singleSite)
    }

    override fun getItemCount(): Int {
        return lists.size
    }
}