package com.learn.newsapplication.presentation.search

sealed class SearchEvent {

    data class UpdateSearch(val searchQuery:String):SearchEvent()

    object SearchNews:SearchEvent()
}