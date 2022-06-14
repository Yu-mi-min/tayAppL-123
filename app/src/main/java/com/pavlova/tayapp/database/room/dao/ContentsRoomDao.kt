package com.pavlova.tayapp.database.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.pavlova.tayapp.model.ContentTestModel
import com.pavlova.tayapp.model.TestModel
import com.pavlova.tayapp.model.TextModel

@Dao
interface ContentsRoomDao {

    @Query("SELECT * FROM text_table")
// функция получения всех файлов из базы данных
    fun getAllContents(): LiveData<List<TextModel>>

//  функции добавления, изменения, удаления тем
    @Insert
    suspend fun addContent(textModel: TextModel)

    @Insert
    suspend fun addTest(testModel: TestModel)

    @Update
    suspend fun updateContent(textModel: TextModel)

    @Delete
    suspend fun deleteContent(textModel: TextModel)
}