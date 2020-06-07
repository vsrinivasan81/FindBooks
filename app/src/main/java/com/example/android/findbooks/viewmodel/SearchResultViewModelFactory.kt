package com.example.android.findbooks.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class SearchResultViewModelFactory (
    private val searchText: String): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SearchResultViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return SearchResultViewModel(searchText) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}