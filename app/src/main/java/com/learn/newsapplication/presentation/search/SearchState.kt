package com.learn.newsapplication.presentation.search

import androidx.paging.PagingData
import com.learn.newsapplication.domain.model.Article
import kotlinx.coroutines.flow.Flow


data class SearchState(
    val searchQuery:String = "",
    val articles: Flow<PagingData<Article>>?= null
)