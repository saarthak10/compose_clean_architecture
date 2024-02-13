package com.learn.newsapplication.domain.usecases.news

import androidx.paging.PagingData
import com.learn.newsapplication.domain.model.Article
import com.learn.newsapplication.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class SearchNews(
    private val newsRepository: NewsRepository
) {
    operator fun invoke( search:String,sources:List<String>):Flow<PagingData<Article>>{
        return newsRepository.searchNews(
            searchQuery = search,
            sources = sources
        )
    }

}