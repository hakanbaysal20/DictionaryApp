package com.hakanbaysal20.dictionaryapp.data.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.hakanbaysal20.dictionaryapp.data.entity.WordModel
import com.hakanbaysal20.dictionaryapp.room.DataDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WordDaoRepository(var kDao:DataDao) {

    val wordList:MutableLiveData<List<WordModel>>

    init {
        wordList = MutableLiveData()
    }
    fun getWord() {
        val job = CoroutineScope(Dispatchers.Main).launch {
            kDao.getWord()
            val a = kDao.getWord()
            for (i in a){
                Log.e("asd",i.word_ingilizce)
            }
        }
    }
    fun searchWord(word:String) {
        val job = CoroutineScope(Dispatchers.Main).launch {
            kDao.searchWord(word)
            val a = kDao.searchWord(word)
            for (i in a){
                i.word_turkce
            }
        }

    }
    fun getWordVm():MutableLiveData<List<WordModel>> {
        return wordList
    }
}