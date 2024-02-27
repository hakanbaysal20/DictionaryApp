package com.hakanbaysal20.dictionaryapp.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.hakanbaysal20.dictionaryapp.data.entity.WordModel

@Database(entities = [WordModel::class], version = 1)
abstract class IDatabase:RoomDatabase() {

    abstract fun getWordDao():DataDao

    companion object{
        var INSTANCE: IDatabase? = null
        fun databaseAccess(context:Context) : IDatabase? {
            if(INSTANCE == null){
                synchronized(IDatabase::class){
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        IDatabase::class.java,
                        "sozluk.sqlite").createFromAsset("sozluk.sqlite").build()
                }
            }
            return INSTANCE
        }
    }
}