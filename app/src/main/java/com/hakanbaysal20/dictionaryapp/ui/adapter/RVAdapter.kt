package com.hakanbaysal20.dictionaryapp.ui.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.hakanbaysal20.dictionaryapp.R
import com.hakanbaysal20.dictionaryapp.data.entity.WordModel
import com.hakanbaysal20.dictionaryapp.databinding.WordViewBinding
import com.hakanbaysal20.dictionaryapp.ui.fragment.HomeFragmentDirections
import com.hakanbaysal20.dictionaryapp.ui.viewmodel.HomeViewModel
import com.hakanbaysal20.dictionaryapp.utils.push

data class RVAdapter(
    private val mContext:Context,
    private val wordList:List<WordModel>,
    private val viewModel:HomeViewModel)
    :RecyclerView.Adapter<RVAdapter.RVAdapterBindingHolder>(){

    inner class RVAdapterBindingHolder(view:WordViewBinding):RecyclerView.ViewHolder(view.root){
        var binding : WordViewBinding

        init {
           this.binding = view

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVAdapterBindingHolder {
        val layoutInflater = LayoutInflater.from(mContext)
        val layout: WordViewBinding = DataBindingUtil.inflate(layoutInflater,R.layout.word_view,parent,false)
        return RVAdapterBindingHolder(layout)
    }

    override fun getItemCount(): Int {
        return  wordList.size
    }

    override fun onBindViewHolder(holder: RVAdapterBindingHolder, position: Int) {
        val word = wordList.get(position)
        val b = holder.binding
        b.wordObject = word
        b.wordCard.setOnClickListener {
            val push = HomeFragmentDirections.pushDetailPage(word)
            Navigation.push(push,it)
        }

    }
}