package com.hakanbaysal20.dictionaryapp.utils

import android.view.View
import androidx.navigation.NavDirections
import androidx.navigation.Navigation

fun Navigation.push(it: View, id:Int) {
    findNavController(it).navigate(id)
}
fun Navigation.push(id: NavDirections, it: View){
    findNavController(it).navigate(id)
}