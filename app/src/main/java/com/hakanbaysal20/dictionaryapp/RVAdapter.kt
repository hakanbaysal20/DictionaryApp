package com.hakanbaysal20.dictionaryapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

data class RVAdapter(private val mContext:Context,private val wordList:List<WordModel>)
    :RecyclerView.Adapter<RVAdapter.RVAdapterBindingHolder>(){

    inner class RVAdapterBindingHolder(view:View):RecyclerView.ViewHolder(view){
        var word_turkce: TextView
        var word_ingilizce: TextView
        var cardView: CardView
        init {
            cardView = view.findViewById(R.id.word_card)
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
        val word = wordList.get(position)
        holder.cardView.setOnClickListener {
            val intent = Intent(mContext,WordDetail::class.java)
            intent.putExtra("object",word)
            mContext.startActivity(intent)
        }
        holder.word_turkce.text = word.word_turkce
        holder.word_ingilizce.text = word.word_ingilizce
    }
}