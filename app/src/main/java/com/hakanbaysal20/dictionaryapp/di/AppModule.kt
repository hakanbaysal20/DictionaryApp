package com.hakanbaysal20.dictionaryapp.di

import android.content.Context
import androidx.room.Room
import com.hakanbaysal20.dictionaryapp.data.repository.WordDaoRepository
import com.hakanbaysal20.dictionaryapp.room.IDatabase
import com.hakanbaysal20.dictionaryapp.room.DataDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideWordDaoRepository(kDao:DataDao) : WordDaoRepository{
        return  WordDaoRepository(kDao)
    }
    @Provides
    @Singleton
    fun provideDataDao(@ApplicationContext context: Context) : DataDao {
        val db = Room.databaseBuilder(context,IDatabase::class.java,"sozluk.sqlite").createFromAsset("sozluk.sqlite").build()
        return db.getWordDao()
    }
}