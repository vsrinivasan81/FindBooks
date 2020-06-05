package com.example.android.findbooks.navigation

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.android.findbooks.R
import com.example.android.findbooks.databinding.FragmentBookSearchBinding
import com.google.android.material.button.MaterialButton

class BookSearchFragment : Fragment() {

    private lateinit var binding: FragmentBookSearchBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBookSearchBinding.inflate(inflater,container,false)
        binding.searchSubmitButton.let { submitButton : MaterialButton ->
            submitButton.setOnClickListener {
                clickHandler(it)
            }
        }
        setHasOptionsMenu(true)
        return binding.root
    }

    private fun clickHandler(view:View) {
        view.findNavController().navigate(R.id.action_bookSearch_to_searchResults)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(
            item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }
}