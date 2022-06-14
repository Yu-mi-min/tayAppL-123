package com.pavlova.tayapp.database.room.repository

import androidx.lifecycle.LiveData
import com.pavlova.tayapp.database.DatabaseRepository
import com.pavlova.tayapp.database.room.dao.ContentsRoomDao
import com.pavlova.tayapp.model.ContentTestModel
import com.pavlova.tayapp.model.TestModel
import com.pavlova.tayapp.model.TextModel

class RoomRepository(private val contentsRoomDao: ContentsRoomDao): DatabaseRepository {
    override val readAll: LiveData<List<TextModel>>
        get() = contentsRoomDao.getAllContents()

    override suspend fun create(textModel: TextModel, onSuccess: () -> Unit) {
        contentsRoomDao.addContent(textModel = textModel)
        onSuccess()
    }
    override suspend fun createTest(testModel: TestModel, onSuccess: () -> Unit) {
        contentsRoomDao.addTest(testModel = testModel)
        onSuccess()
    }

    override suspend fun update(textModel: TextModel, onSuccess: () -> Unit) {
        contentsRoomDao.updateContent(textModel = textModel)
        onSuccess()
    }

    override suspend fun delete(textModel: TextModel, onSuccess: () -> Unit) {
        contentsRoomDao.deleteContent(textModel = textModel)
        onSuccess()
    }

    override fun signOut() {}
}