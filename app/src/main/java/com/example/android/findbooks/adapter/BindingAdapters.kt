package com.example.android.findbooks.adapter

import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.android.findbooks.R
import com.example.android.findbooks.network.Book

@BindingAdapter("imageUrl")
fun ImageView.setImageSrc(bookItem: Book?) {
    val imgUrl: String = bookItem?.volumeInfo?.imageLinks?.thumbnail.toString()
    imgUrl.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        Glide.with(context)
            .load(imgUri)
            .apply(
                RequestOptions()
                        .placeholder(R.drawable.ic_loading_animation)
                        .error(R.drawable.ic_broken_image)
            )
            .into(this)
    }

}

@BindingAdapter("bookTitle")
fun TextView.setBookTitle(bookItem: Book?) {
    bookItem?.let {
        val itemTitle = bookItem.volumeInfo?.title
        val bookPageCount = bookItem.volumeInfo?.pageCount.toString()
        var bookTitleInfo = itemTitle
        if(!bookPageCount.equals("null",ignoreCase = true)) {
            bookTitleInfo = itemTitle.plus(" (").plus(bookPageCount).plus(" pages)")
        }
        text = bookTitleInfo
    }
}

@BindingAdapter("bookDescription")
fun TextView.setBookDescription(bookItem: Book?) {
    bookItem?.let {
        text = bookItem.volumeInfo?.description
    }
}

@BindingAdapter("bookPublisherInfo")
fun TextView.setBookPublisher(bookItem: Book?) {
    bookItem?.let {
        val publisher = bookItem.volumeInfo?.publisher
        val publishedDate = bookItem.volumeInfo?.publishedDate
        text = publisher.plus(" ").plus(publishedDate)
    }
}

@BindingAdapter("bookAuthor")
fun TextView.setBookAuthors(bookItem: Book?) {
    bookItem?.let {
        text = bookItem.volumeInfo?.authors?.joinToString(",")
    }
}

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Book>?) {
    val adapter = recyclerView.adapter as SearchResultAdapter
    adapter.submitList(data)
}