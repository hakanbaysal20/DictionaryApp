package com.hakanbaysal20.dictionaryapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.hakanbaysal20.dictionaryapp.R
import com.hakanbaysal20.dictionaryapp.databinding.FragmentWordDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WordDetailFragment : Fragment() {
    private lateinit var binding: FragmentWordDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_word_detail,container,false)

        binding.toolbarTitle = "Detail Page"
        val bundle: WordDetailFragmentArgs by navArgs()

        binding.wordObject = bundle.word

        return binding.root
    }


}