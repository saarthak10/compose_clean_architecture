package com.learn.newsapplication.data.local

import android.content.Context
import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.learn.newsapplication.domain.local.LocalUserStore
import com.learn.newsapplication.utils.Constants
import com.learn.newsapplication.utils.Constants.USER_SETTINGS
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LocalUserStoreImpl(
    private val context:Context
) : LocalUserStore {
    override suspend fun saveAppEntry() {
        context.dataStore.edit {preferences->
            preferences[PreferencesKeys.APP_ENTRY] = true
            Log.d("Test", "saveAppEntry: ${preferences[PreferencesKeys.APP_ENTRY]}")
        }
    }

    override fun readAppEntry(): Flow<Boolean> {
        return context.dataStore.data.map { preferences->
            Log.d("Test", "readAppEntry:${preferences[PreferencesKeys.APP_ENTRY]} ")
            preferences[PreferencesKeys.APP_ENTRY]?:false

        }
    }
}

private val Context.dataStore:DataStore<Preferences> by preferencesDataStore(
    name = USER_SETTINGS
)

private object PreferencesKeys{
    val APP_ENTRY = booleanPreferencesKey(name = Constants.APP_ENTRY )
}