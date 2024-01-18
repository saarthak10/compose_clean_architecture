package com.learn.newsapplication.domain.usecases

import com.learn.newsapplication.domain.local.LocalUserStore

class SaveUserAppEntry(
    private val localUserStore: LocalUserStore
) {

    suspend operator fun invoke(){
        localUserStore.saveAppEntry()
    }
}