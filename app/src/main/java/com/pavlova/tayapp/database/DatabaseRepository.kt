package com.pavlova.tayapp.database

import androidx.lifecycle.LiveData
import com.pavlova.tayapp.model.AccModel
import com.pavlova.tayapp.model.ContentTestModel
import com.pavlova.tayapp.model.TestModel
import com.pavlova.tayapp.model.TextModel

interface DatabaseRepository {
//    считываем все данные из базы данных
    val readAll: LiveData<List<TextModel>>
//    создание, удаление, добавление текста
    suspend fun create(textModel: TextModel, onSuccess: () -> Unit)

    suspend fun createTest(testModel: TestModel, onSuccess: () -> Unit)

    suspend fun update(textModel: TextModel, onSuccess: () -> Unit)

    suspend fun delete(textModel: TextModel, onSuccess: () -> Unit)

    fun signOut() {}

    fun connectToDatabase(onSuccess: () -> Unit, onFail: (String) -> Unit) {}

}
