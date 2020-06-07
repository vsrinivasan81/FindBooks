package com.example.android.findbooks.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.findbooks.network.Book

class BookDetailViewModel (selectedBook: Book) : ViewModel() {

    private val _selectedBookItem = MutableLiveData<Book>()

    val selectedBookItem : LiveData<Book>
        get() = _selectedBookItem

    init {
        _selectedBookItem.value = selectedBook
    }

}