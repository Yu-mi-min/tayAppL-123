package com.pavlova.tayapp.database.firebase

import androidx.lifecycle.LiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.pavlova.tayapp.model.TextModel

class AllContentsLiveData: LiveData<List<TextModel>>() {
    private val mAuth = FirebaseAuth.getInstance()
    private val database = Firebase.database.reference
        .child(mAuth.currentUser?.uid.toString())

    private val listener = object : ValueEventListener {
        override fun onDataChange(snapshot: DataSnapshot) {
            val contents = mutableListOf<TextModel>()
            snapshot.children.map {
                contents.add(it.getValue(TextModel::class.java) ?: TextModel())
            }
            value = contents
        }

        override fun onCancelled(error: DatabaseError) { }

    }

    override fun onActive() {
        database.addValueEventListener(listener)
        super.onActive()
    }

    override fun onInactive() {
        database.removeEventListener(listener)
        super.onInactive()
    }
}