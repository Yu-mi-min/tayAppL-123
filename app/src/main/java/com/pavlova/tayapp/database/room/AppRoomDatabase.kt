package com.pavlova.tayapp.database.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.pavlova.tayapp.Utils.Constants.Keys.CONTENTS_DATABASE
import com.pavlova.tayapp.database.room.dao.ContentsRoomDao
import com.pavlova.tayapp.model.AccModel
import com.pavlova.tayapp.model.ContentTestModel
import com.pavlova.tayapp.model.TestModel
import com.pavlova.tayapp.model.TextModel

@Database(
    entities = [
        TextModel::class,
        ContentTestModel::class,
        TestModel::class,
        AccModel::class
               ],
    version = 1
)
abstract class AppRoomDatabase: RoomDatabase() {

    abstract fun getRoomDao(): ContentsRoomDao

    companion object {
        @Volatile
        private var     INSTANCE: AppRoomDatabase? = null

        fun getInstance(context: Context): AppRoomDatabase {
            return if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context,
                    AppRoomDatabase::class.java,
                    CONTENTS_DATABASE
                ).fallbackToDestructiveMigration()
                    .build()

                INSTANCE as AppRoomDatabase
            }
            else INSTANCE as AppRoomDatabase
        }
    }
}