package com.example.android.findbooks.viewmodel

import androidx.lifecycle.ViewModel
import com.example.android.findbooks.network.BookSearch
import com.example.android.findbooks.network.SearchResult
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Response

class SearchResultViewModel : ViewModel() {

    private var viewModelJob = Job()

    private val coroutineScope = CoroutineScope(viewModelJob+Dispatchers.Main)

    private var _bookList = ArrayList<SearchResult>()

    /*
    init {
        getSearchResults()
    }
    */

    private fun getSearchResults() {
        coroutineScope.launch {
            try {
                val response:Response<List<SearchResult>> = BookSearch
                    .retrofitService.getBooks("Wings of Fire")
                if (response.isSuccessful) {
                    _bookList = response.body()!! as ArrayList<SearchResult>
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
}