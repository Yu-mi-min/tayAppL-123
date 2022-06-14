package com.pavlova.tayapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.pavlova.tayapp.Utils.Constants.Keys.TEXT_TABLE

@Entity(tableName = TEXT_TABLE)
data class TextModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo
    val title: String = "",
    @ColumnInfo
    val subtitle: String= "",
    @ColumnInfo
    val mainText: String= "",
    val firebaseId: String = ""
){

}
