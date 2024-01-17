package com.hakanbaysal20.dictionaryapp

class Worddao {

    fun getWord(vba:DatabaseAccess):ArrayList<WordModel> {
        val vb = vba.writableDatabase
        val cursor = vb.rawQuery("SELECT * FROM kelimeler",null)
        val wordList = ArrayList<WordModel>()
        val word_id = cursor.getColumnIndex("kelime_id")
        val word_turkce = cursor.getColumnIndex("turkce")
        val word_ingilizce = cursor.getColumnIndex("ingilizce")

        while (cursor.moveToNext()){
            val word = WordModel(cursor.getInt(word_id),cursor.getString(word_turkce),cursor.getString(word_ingilizce))
            wordList.add(word)
        }
        return wordList
    }
    fun getWordBySearch(vba:DatabaseAccess,searchWord:String):ArrayList<WordModel> {
        val vb = vba.writableDatabase
        val cursor = vb.rawQuery("SELECT * FROM kelimeler WHERE ingilizce like '%$searchWord%'",null)
        val searchedList = ArrayList<WordModel>()
        val word_id = cursor.getColumnIndex("kelime_id")
        val word_turkce = cursor.getColumnIndex("turkce")
        val word_ingilizce = cursor.getColumnIndex("ingilizce")

        while (cursor.moveToNext()){
            val word = WordModel(cursor.getInt(word_id),cursor.getString(word_turkce),cursor.getString(word_ingilizce))
            searchedList.add(word)
        }
        return searchedList
    }
}