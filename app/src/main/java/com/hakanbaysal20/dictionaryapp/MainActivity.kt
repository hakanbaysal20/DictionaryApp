package com.hakanbaysal20.dictionaryapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.hakanbaysal20.dictionaryapp.databinding.ActivityMainBinding
import com.info.sqlitekullanimihazirveritabani.DatabaseCopyHelper

class MainActivity : AppCompatActivity(),SearchView.OnQueryTextListener {
    private lateinit var binding:ActivityMainBinding
    private lateinit var adapter:RVAdapter
    private lateinit var list: ArrayList<WordModel>
    private lateinit var vb:DatabaseAccess
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // copy database
        copyDatabase()
        // database access
        vb = DatabaseAccess(this)
        // toolbar act
        setSupportActionBar(binding.toolbar)

        // recycler view adapter
        binding.wordViewRV.setHasFixedSize(true)
        binding.wordViewRV.layoutManager = LinearLayoutManager(applicationContext)

        // connect sqlite fun
        list = Worddao().getWord(vb)
        adapter = RVAdapter(this,list)
        binding.wordViewRV.adapter = adapter
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_search,menu)
        val item = menu.findItem(R.id.action_search)
        val searchView = item.actionView as SearchView
        searchView.setOnQueryTextListener(this)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onQueryTextSubmit(query: String): Boolean { // arama tuşuna basıldıgında calısır
        search(query)
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean { // her harf girildiği zaman çalışır
        search(newText)
        return true
    }
    fun search(searchWord:String) {
        list = Worddao().getWordBySearch(vb,searchWord)
        adapter = RVAdapter(this,list)
        binding.wordViewRV.adapter = adapter
    }
    private fun copyDatabase() {
        val db = DatabaseCopyHelper(applicationContext)

        try {
            db.createDataBase()
        }catch (e:Exception){
            e.printStackTrace()
        }
        try {
            db.openDataBase()
        }catch (e:Exception){
            e.printStackTrace()
        }
    }
}