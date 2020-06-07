package com.example.android.findbooks.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.android.findbooks.adapter.SearchResultAdapter
import com.example.android.findbooks.databinding.FragmentSearchResultsBinding
import com.example.android.findbooks.viewmodel.SearchResultViewModel
import com.example.android.findbooks.viewmodel.SearchResultViewModelFactory

class SearchResultFragment : Fragment() {

    private lateinit var binding: FragmentSearchResultsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSearchResultsBinding.inflate(
            layoutInflater, container, false)

        val args = SearchResultFragmentArgs.fromBundle(requireArguments())
        val viewModelFactory = SearchResultViewModelFactory(args.searchText)
        val searchResultViewModel = ViewModelProvider(this, viewModelFactory)
            .get(SearchResultViewModel::class.java)

        binding.viewModel = searchResultViewModel
        binding.lifecycleOwner = viewLifecycleOwner

        binding.resultsRecyclerview.adapter = SearchResultAdapter(SearchResultAdapter.OnClickListener {
            searchResultViewModel.displayPropertyDetails(it)
        })

        searchResultViewModel.navigateToSelectedBook.observe(viewLifecycleOwner, Observer {
            if ( null != it ) {
                this.findNavController().navigate(SearchResultFragmentDirections.actionSearchResultsToBookDetailFragment(it))
                searchResultViewModel.displayBookDetailsComplete()
            }
        })

        return binding.root
    }
}