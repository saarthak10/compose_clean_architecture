package com.learn.newsapplication.domain.local

import kotlinx.coroutines.flow.Flow

interface LocalUserStore {

    suspend fun saveAppEntry()
    fun readAppEntry(): Flow<Boolean>
}