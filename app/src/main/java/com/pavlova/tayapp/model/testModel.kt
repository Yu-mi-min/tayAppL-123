package com.pavlova.tayapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.pavlova.tayapp.R
import com.pavlova.tayapp.Utils.Constants

@Entity(tableName = Constants.Keys.TEST_TABLE)
data class TestModel(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,

    @ColumnInfo
    val mainText: Int,
    @ColumnInfo
    val rightAnswer: Int?,
    @ColumnInfo
    var answer1: Int ?= 1,
    @ColumnInfo
    var answer2: Int = 2,
    @ColumnInfo
    var answer3: Int ?= 3,
    @ColumnInfo
    var answer4: Int ?= 4,
    @ColumnInfo
    var answer5: Int ?= 5


    ){

}
