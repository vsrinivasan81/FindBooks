package com.example.android.findbooks.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.android.findbooks.R
import com.example.android.findbooks.utils.Book
import com.google.android.material.textview.MaterialTextView

class SearchResultAdapter (private val resultsList : ArrayList<Book>) :
    RecyclerView.Adapter<SearchResultAdapter.ResultsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.book_card_view, parent, false)

        return ResultsViewHolder(view)
    }

    override fun getItemCount() = resultsList.size

    override fun onBindViewHolder(holder: ResultsViewHolder, position: Int) {
        holder.textView.text = resultsList[position].title
        holder.imageView.setImageResource(R.drawable.splash_logo)
    }

    class ResultsViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        var imageView: ImageView = itemView.findViewById(R.id.item_image)
        var textView: MaterialTextView = itemView.findViewById(R.id.item_title)
    }


}