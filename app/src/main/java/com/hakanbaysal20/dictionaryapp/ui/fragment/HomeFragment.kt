package com.hakanbaysal20.dictionaryapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.hakanbaysal20.dictionaryapp.R
import com.hakanbaysal20.dictionaryapp.databinding.FragmentHomeBinding
import com.hakanbaysal20.dictionaryapp.ui.adapter.RVAdapter
import com.hakanbaysal20.dictionaryapp.ui.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(), SearchView.OnQueryTextListener {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel:HomeViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_home,container,false)
        binding.homeFragment = this

        binding.toolbarTitle = "Dictionary App"

        viewModel.wordList.observe(viewLifecycleOwner){
            val adapter = RVAdapter(requireContext(),it,viewModel)
            binding.wordAdapter = adapter

        }
        (activity as AppCompatActivity).setSupportActionBar(binding.homeToolbar)
        requireActivity().addMenuProvider(object : MenuProvider{
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.menu_search,menu)
                val item = menu.findItem(R.id.search)
                val searchView = item.actionView as SearchView
                searchView.setOnQueryTextListener(this@HomeFragment)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return false
            }

        })
        return binding.root
    }


    override fun onResume() {
        super.onResume()
        viewModel.getWords()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : HomeViewModel by viewModels()
        viewModel = tempViewModel
    }

    override fun onQueryTextSubmit(query: String): Boolean {
        viewModel.searchWord(query)
       return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
        viewModel.searchWord(newText)
        return true
    }
}