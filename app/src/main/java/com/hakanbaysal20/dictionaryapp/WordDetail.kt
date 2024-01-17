package com.hakanbaysal20.dictionaryapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.hakanbaysal20.dictionaryapp.databinding.ActivityWordDetailBinding

class WordDetail : AppCompatActivity() {
    private lateinit var binding:ActivityWordDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWordDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.detailToolbar.title = "Word Detail"
        val word = intent.getSerializableExtra("object") as WordModel
        binding.textTurkish.text = word.word_turkce
        binding.textEnglish.text = word.word_ingilizce
    }
}