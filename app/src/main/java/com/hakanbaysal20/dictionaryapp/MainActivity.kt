package com.hakanbaysal20.dictionaryapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
        copyDatabase()
        vb = DatabaseAccess(this)
        setSupportActionBar(binding.toolbar)
        binding.wordViewRV.setHasFixedSize(true)
        binding.wordViewRV.layoutManager = LinearLayoutManager(applicationContext)
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
    override fun onQueryTextSubmit(query: String?): Boolean { // arama tuşuna basıldıgında calısır
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean { // her har girildiği zaman çalışır
        return true
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