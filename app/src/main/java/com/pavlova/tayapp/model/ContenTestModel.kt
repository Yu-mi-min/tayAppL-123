package com.pavlova.tayapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.pavlova.tayapp.Utils.Constants
import com.pavlova.tayapp.Utils.Constants.Keys.CONTENT_TEST_TABLE
import com.pavlova.tayapp.Utils.Constants.Keys.TEST_TABLE


@Entity(tableName = CONTENT_TEST_TABLE)
data class ContentTestModel(
  @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
      @ColumnInfo
    val title: String = "",
    @ColumnInfo
    val subtitle: String= "",
    @ColumnInfo
    val mainText: String = "",


){

}
