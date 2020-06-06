package com.example.android.findbooks.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.android.findbooks.adapter.SearchResultAdapter
import com.example.android.findbooks.databinding.FragmentSearchResultsBinding
import com.example.android.findbooks.utils.Book
import com.example.android.findbooks.viewmodel.SearchResultViewModel
import timber.log.Timber

class SearchResultFragment : Fragment() {

    private var bookList : ArrayList<Book> = ArrayList()
    private lateinit var binding: FragmentSearchResultsBinding
    private lateinit var gridLayoutManager: GridLayoutManager
    private lateinit var searchResultAdapter: SearchResultAdapter
    private lateinit var args: SearchResultFragmentArgs
    private val viewModel:SearchResultViewModel by viewModels()

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
        binding.viewModel = viewModel

        args = SearchResultFragmentArgs.fromBundle(requireArguments())
        val searchText:String = args.searchText
        Timber.i("Search text : $searchText")

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