package com.hakanbaysal20.dictionaryapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

data class RVAdapter(private val mContext:Context,private val wordList:List<WordModel>)
    :RecyclerView.Adapter<RVAdapter.RVAdapterBindingHolder>(){

    inner class RVAdapterBindingHolder(view:View):RecyclerView.ViewHolder(view){
        var word_turkce: TextView
        var word_ingilizce: TextView

        init {
            word_turkce = view.findViewById(R.id.textWord)
            word_ingilizce = view.findViewById(R.id.textMeaning)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVAdapterBindingHolder {
        val binding = LayoutInflater.from(mContext).inflate(R.layout.word_view,parent,false)
        return RVAdapterBindingHolder(binding)
    }

    override fun getItemCount(): Int {
        return  wordList.size
    }

    override fun onBindViewHolder(holder: RVAdapterBindingHolder, position: Int) {
        val model = wordList[position]
        holder.word_turkce.text = model.word_turkce
        holder.word_ingilizce.text = model.word_ingilizce
    }
}