package com.example.core_database_impl.data.session

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.example.core_database_api.data.repository.SessionManager
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map

class SessionManagerImpl(
    private val dataStore: DataStore<Preferences>
): SessionManager {
    companion object {
        private val USER_TOKEN_KEY = stringPreferencesKey("user_token")
    }

    override suspend fun saveUserToken(token: String) {
        dataStore.edit { it[USER_TOKEN_KEY] = token }
    }

    override suspend fun getUserToken(): String? {
        return dataStore.data.map { it[USER_TOKEN_KEY] }.firstOrNull()
    }

    override suspend fun clearSession() {
        dataStore.edit { it.remove(USER_TOKEN_KEY) }
    }
}