package com.pavlova.tayapp

import android.app.Application
import android.util.Log
import androidx.compose.runtime.Composable

import androidx.lifecycle.*
import com.pavlova.tayapp.Utils.*
import com.pavlova.tayapp.database.firebase.AppFirebaseRepository
import com.pavlova.tayapp.database.room.AppRoomDatabase
import com.pavlova.tayapp.database.room.repository.RoomRepository
import com.pavlova.tayapp.model.ContentTestModel
import com.pavlova.tayapp.model.TestModel
import com.pavlova.tayapp.model.TextModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

var errorEx = false
class MainViewModel (application: Application): AndroidViewModel(application) {

   val context = application

    fun initDatabase(type: String, onSuccess: () -> Unit){
        Log.d("checkData", "MainViewModel initDatabase with type: $type")
        when(type){
            TYPE_ROOM -> {
                val dao = AppRoomDatabase.getInstance(context = context).getRoomDao()
                REPOSITORY = RoomRepository(dao)
                onSuccess()
            }
            TYPE_FIREBASE -> {
                REPOSITORY = AppFirebaseRepository()
                REPOSITORY.connectToDatabase(
                    {onSuccess()
                        errorEx = false},
                    {
                        Log.d("checkData", "Error: ${it}")
                        errorEx = true
                    }
                )
            }
        }
    }
    fun addContent(textModel: TextModel,onSuccess: () -> Unit){
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.create(textModel = textModel){
                viewModelScope.launch(Dispatchers.Main){
                    onSuccess()
                }
            }
        }
    }


    fun updateContentText(textModel: TextModel, onSuccess: () -> Unit){
        viewModelScope.launch(Dispatchers.IO){
            REPOSITORY.update(textModel = textModel){
                viewModelScope.launch  (Dispatchers.Main){
                    onSuccess()
                }
            }
        }
    }
    fun deleteContentText(textModel: TextModel, onSuccess: () -> Unit){
        viewModelScope.launch(Dispatchers.IO){
            REPOSITORY.delete(textModel = textModel){
                viewModelScope.launch  (Dispatchers.Main){
                    onSuccess()
                }
            }
        }
    }
    fun readAllContents() = REPOSITORY.readAll

    fun signOut(onSuccess: () -> Unit) {
        when (DB_TYPE.value) {
            TYPE_FIREBASE,
            TYPE_ROOM -> {
                REPOSITORY.signOut()
                DB_TYPE.value = Constants.Keys.EMPTY
                onSuccess()
            }
            else -> {
                Log.d("checkData", "Error signOut. else ${DB_TYPE.value}")
            }
        }
    }
    fun addTest(testModel: TestModel, onSuccess: () -> Unit){
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.createTest(testModel = testModel){
                viewModelScope.launch(Dispatchers.Main){
                    onSuccess()
                }
            }
        }
    }
}


class MainViewModelFactory(private val application: Application): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)){
            return MainViewModel(application = application) as T

        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }

}