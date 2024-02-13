package com.learn.newsapplication.presentation.search

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.learn.newsapplication.domain.usecases.news.NewsUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val newsUseCases: NewsUseCases
):ViewModel() {

    private val _state = mutableStateOf(SearchState())
    val searchState: State<SearchState> = _state
    fun onEvent(e: SearchEvent){
        when(e){
            is SearchEvent.UpdateSearch->{
                _state.value = _state.value.copy(searchQuery = e.searchQuery)
            }
            is SearchEvent.SearchNews->{
                searchNews()
            }
            else->{
                null
            }
        }

    }

    private fun searchNews() {
        val articles = newsUseCases.searchNews(
            search = searchState.value.searchQuery,
            sources =  listOf("bbc-news","abc-news","al-jazeera-english")
        ).cachedIn(viewModelScope)
        _state.value = _state.value.copy(articles = articles)
    }
}