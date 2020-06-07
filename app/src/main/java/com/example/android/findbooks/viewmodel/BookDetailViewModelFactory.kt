package com.example.android.findbooks.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android.findbooks.network.Book

class BookDetailViewModelFactory(
    private val bookItem: Book) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BookDetailViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return BookDetailViewModel(bookItem) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}