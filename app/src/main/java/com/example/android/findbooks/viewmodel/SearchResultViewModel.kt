package com.example.android.findbooks.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.findbooks.network.Book
import com.example.android.findbooks.network.BookSearch
import com.example.android.findbooks.network.SearchResult
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Response

class SearchResultViewModel(searchText: String) : ViewModel() {

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob+Dispatchers.Main)

    private val _booksList = MutableLiveData<List<Book>>()
    val bookList : LiveData<List<Book>>
        get() = _booksList

    private val _navigateToSelectedBook = MutableLiveData<Book>()
    val navigateToSelectedBook: LiveData<Book>
        get() = _navigateToSelectedBook

    init {
        getSearchResults(searchText)
    }

    private fun getSearchResults(searchText:String) {
        coroutineScope.launch {
            try {
                val response:Response<SearchResult> = BookSearch
                    .retrofitService.getBooks(searchText,"25", "NOT_MATURE")

                if (response.isSuccessful) {
                    _booksList.value = response.body()?.items
                }

            } catch (e:Exception) {
                throw e
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    fun displayBookDetailsComplete() {
        _navigateToSelectedBook.value = null
    }

    fun displayPropertyDetails(bookItem:Book) {
        _navigateToSelectedBook.value = bookItem

    }
}