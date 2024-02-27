package com.hakanbaysal20.dictionaryapp.data.entity
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.io.Serializable

@Entity(tableName = "kelimeler")
class WordModel(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("kelime_id") @NotNull var word_id:Int,
    @ColumnInfo("turkce")  @NotNull var word_turkce:String,
    @ColumnInfo("ingilizce") @NotNull var word_ingilizce:String):Serializable {
}