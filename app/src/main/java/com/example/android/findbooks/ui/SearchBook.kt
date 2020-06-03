package com.example.android.findbooks.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.android.findbooks.R
import com.example.android.findbooks.databinding.FragmentBookSearchBinding
import com.google.android.material.button.MaterialButton

class SearchBook : Fragment() {

    private lateinit var binding: FragmentBookSearchBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentBookSearchBinding.inflate(inflater,container,false)

        binding.searchSubmitButton.setOnClickListener {
            findNavController().navigate(R.id.action_bookSearch_to_searchResults)
        }

        return binding.root
    }
}