package com.pavlova.tayapp.database.firebase

import android.util.Log
import androidx.lifecycle.LiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.pavlova.tayapp.Utils.Constants
import com.pavlova.tayapp.Utils.FIREBASE_ID
import com.pavlova.tayapp.Utils.LOGIN
import com.pavlova.tayapp.Utils.PASSWORD
import com.pavlova.tayapp.database.DatabaseRepository
import com.pavlova.tayapp.model.AccModel
import com.pavlova.tayapp.model.ContentTestModel
import com.pavlova.tayapp.model.TestModel
import com.pavlova.tayapp.model.TextModel

class AppFirebaseRepository: DatabaseRepository {
    private val mAuth = FirebaseAuth.getInstance()
    private val database = Firebase.database.reference
        .child(mAuth.currentUser?.uid.toString())

    override val readAll: LiveData<List<TextModel>> = AllContentsLiveData()

    override suspend fun create(textModel: TextModel, onSuccess: () -> Unit) {
        val contentId = database.push().key.toString()
        val mapContentsText = hashMapOf<String, Any>()

        mapContentsText[FIREBASE_ID] = contentId
        mapContentsText[Constants.Keys.TITLE] = textModel.title
        mapContentsText[Constants.Keys.SUBTITLE] = textModel.subtitle
        mapContentsText[Constants.Keys.MAIN_TEXT] = textModel.mainText

        database.child(contentId)
            .updateChildren(mapContentsText)
            .addOnSuccessListener { onSuccess() }
            .addOnFailureListener { Log.d("checkData", "Error" )}
    }

    override suspend fun createTest(testModel: TestModel, onSuccess: () -> Unit) {
        TODO("Not yet implemented")
    }

    override suspend fun update(textModel: TextModel, onSuccess: () -> Unit) {
        val contentId = textModel.firebaseId
        val mapContentsText = hashMapOf<String, Any>()

        mapContentsText[FIREBASE_ID] = contentId
        mapContentsText[Constants.Keys.TITLE] = textModel.title
        mapContentsText[Constants.Keys.SUBTITLE] = textModel.subtitle
        mapContentsText[Constants.Keys.MAIN_TEXT] = textModel.mainText

        database.child(contentId)
            .updateChildren(mapContentsText)
            .addOnSuccessListener { onSuccess() }
            .addOnFailureListener { Log.d("checkData", "Update error") }
    }

    override suspend fun delete(textModel: TextModel, onSuccess: () -> Unit) {
        database.child(textModel.firebaseId).removeValue()
            .addOnSuccessListener { onSuccess() }
            .addOnFailureListener { Log.d("checkData", "Delete error") }
    }

    override fun signOut() {
        mAuth.signOut()

    }

    override fun connectToDatabase(onSuccess: () -> Unit, onFail: (String) -> Unit) {
        mAuth.signInWithEmailAndPassword(LOGIN, PASSWORD)
            .addOnSuccessListener { onSuccess() }
            .addOnFailureListener {
                mAuth.createUserWithEmailAndPassword(LOGIN, PASSWORD)
                    .addOnSuccessListener { onSuccess() }
                    .addOnFailureListener { onFail(it.message.toString()) }
            }
    }

}