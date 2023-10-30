package com.example.artecles.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.artecles.data.models.view.Result
import com.example.artecles.databinding.AtricleListItemBinding

class ArticlesAdapter : ListAdapter<Result, ArticlesAdapter.ArticlesViewHolder>(ArticleDiffUtil) {

    companion object {
        object ArticleDiffUtil : DiffUtil.ItemCallback<Result>() {
            override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
                return oldItem == newItem
            }

        }
    }

    class ArticlesViewHolder(
        private val binding: AtricleListItemBinding
    ) : ViewHolder(binding.root) {


        fun bind(item: Result) {
            binding.apply {
                articleTitle.text = item.title
            }
        }

        companion object {
            fun from(parent: ViewGroup): ArticlesViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val binding = AtricleListItemBinding.inflate(inflater, parent, false)
                return ArticlesViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticlesViewHolder {
        return ArticlesViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ArticlesViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

}