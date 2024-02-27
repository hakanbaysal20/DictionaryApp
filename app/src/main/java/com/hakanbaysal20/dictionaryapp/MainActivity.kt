package com.hakanbaysal20.dictionaryapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.hakanbaysal20.dictionaryapp.data.entity.WordModel
import com.hakanbaysal20.dictionaryapp.databinding.ActivityMainBinding
import com.hakanbaysal20.dictionaryapp.ui.adapter.RVAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}