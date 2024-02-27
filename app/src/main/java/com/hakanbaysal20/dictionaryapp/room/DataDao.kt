package com.hakanbaysal20.dictionaryapp.room

import androidx.room.Dao
import androidx.room.Query
import com.hakanbaysal20.dictionaryapp.data.entity.WordModel

@Dao
interface DataDao {

    @Query("SELECT * FROM kelimeler")
    suspend fun getWord():List<WordModel>
    @Query("SELECT * FROM kelimeler WHERE turkce like '%' || :word || '%'")
    suspend fun searchWord(word:String):List<WordModel>
}