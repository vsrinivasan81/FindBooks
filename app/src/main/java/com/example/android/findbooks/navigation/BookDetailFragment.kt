package com.example.android.findbooks.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.android.findbooks.databinding.FragmentBookDetailBinding
import com.example.android.findbooks.network.Book
import com.example.android.findbooks.viewmodel.BookDetailViewModel
import com.example.android.findbooks.viewmodel.BookDetailViewModelFactory

class BookDetailFragment : Fragment() {

    private lateinit var viewModel: BookDetailViewModel
    private lateinit var bookDetailBinding: FragmentBookDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        bookDetailBinding = FragmentBookDetailBinding
                                .inflate(inflater,container, false)

        val bookItem:Book = BookDetailFragmentArgs
                                .fromBundle(requireArguments()).selectedBook
        val viewModelFactory = BookDetailViewModelFactory(bookItem)
        viewModel = ViewModelProvider(this, viewModelFactory)
            .get(BookDetailViewModel::class.java)

        bookDetailBinding.viewModel = viewModel
        bookDetailBinding.lifecycleOwner = viewLifecycleOwner

        return bookDetailBinding.root
    }



}