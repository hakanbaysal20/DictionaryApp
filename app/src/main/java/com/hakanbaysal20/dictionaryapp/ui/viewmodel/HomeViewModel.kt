package com.hakanbaysal20.dictionaryapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hakanbaysal20.dictionaryapp.data.entity.WordModel
import com.hakanbaysal20.dictionaryapp.data.repository.WordDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor( var wRepo: WordDaoRepository) : ViewModel() {


    var wordList = MutableLiveData<List<WordModel>>()
    init {
        getWords()
        wordList = wRepo.getWordVm()
    }

    fun searchWord(word:String) {
        wRepo.searchWord(word)
    }
    fun getWords() {
        wRepo.getWord()
    }
}