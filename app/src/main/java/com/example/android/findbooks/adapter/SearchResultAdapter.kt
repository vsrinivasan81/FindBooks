package com.example.android.findbooks.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.findbooks.databinding.GridItemViewBinding
import com.example.android.findbooks.network.Book

class SearchResultAdapter(private val onClickListener: OnClickListener) :
    ListAdapter<Book, SearchResultAdapter.ResultsViewHolder>(BookDiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultsViewHolder {
        return ResultsViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ResultsViewHolder, position: Int) {
        val bookItem = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(bookItem)
        }
        holder.bind(bookItem)
    }

    class ResultsViewHolder private constructor
        (private val binding: GridItemViewBinding):RecyclerView.ViewHolder(binding.root) {

        fun bind(bookItem: Book) {
            binding.book = bookItem
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ResultsViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = GridItemViewBinding.inflate(layoutInflater, parent, false)
                return ResultsViewHolder(binding)
            }
        }
    }

    class OnClickListener(val clickListener: (selectedBook:Book) -> Unit) {
        fun onClick(selectedBook:Book) = clickListener(selectedBook)
    }
}

class BookDiffCallBack: DiffUtil.ItemCallback<Book>() {
    override fun areItemsTheSame(oldItem: Book, newItem: Book): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Book, newItem: Book): Boolean {
        return oldItem == newItem
    }
}