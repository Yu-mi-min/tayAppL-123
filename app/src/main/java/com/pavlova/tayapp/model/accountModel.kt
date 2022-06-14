package com.pavlova.tayapp.model

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.pavlova.tayapp.Utils.Constants
import kotlinx.coroutines.flow.map
import java.util.concurrent.Flow
import java.util.prefs.Preferences
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty


@Entity(tableName = Constants.Keys.ACCOUNT)
data class AccModel(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,

    @ColumnInfo
    val email: String,
    @ColumnInfo
    val password: String,
){

}
@Entity(tableName = "last_results")
data class LastHistory(


    var id: Int = 0,

    @ColumnInfo
    val email: String,
    @ColumnInfo
    val password: String,
){

}
@Composable
fun account(){

}


