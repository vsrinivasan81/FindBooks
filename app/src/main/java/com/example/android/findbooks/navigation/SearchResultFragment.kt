package com.example.android.findbooks.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.android.findbooks.adapter.SearchResultAdapter
import com.example.android.findbooks.databinding.FragmentSearchResultsBinding
import com.example.android.findbooks.utils.Book
import com.example.android.findbooks.viewmodel.SearchResultViewModel

class SearchResultFragment : Fragment() {

    private var bookList : ArrayList<Book> = ArrayList()
    private lateinit var binding: FragmentSearchResultsBinding
    private lateinit var gridLayoutManager: GridLayoutManager
    private lateinit var searchResultAdapter: SearchResultAdapter

    init {
        bookList.add(Book("Harry", ""))
        bookList.add(Book("Ron", ""))
        bookList.add(Book("Hermoine", ""))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchResultsBinding.inflate(
            layoutInflater, container, false)

        val viewModel: SearchResultViewModel = ViewModelProvider(this)
            .get(SearchResultViewModel::class.java)

        binding.viewModel = viewModel

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        gridLayoutManager = GridLayoutManager(view.context, 3)
        searchResultAdapter = SearchResultAdapter(bookList)
        binding.resultsRecyclerview.layoutManager = gridLayoutManager
        binding.resultsRecyclerview.adapter = searchResultAdapter

    }
}