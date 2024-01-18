package com.learn.newsapplication.domain.usecases

import com.learn.newsapplication.domain.local.LocalUserStore
import kotlinx.coroutines.flow.Flow

class ReadUserAppEntry(
    private val localUserStore: LocalUserStore
) {

     operator fun invoke():Flow<Boolean>{
        return localUserStore.readAppEntry()
    }
}