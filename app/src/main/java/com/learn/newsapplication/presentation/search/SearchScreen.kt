package com.learn.newsapplication.presentation.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.compose.collectAsLazyPagingItems
import com.learn.newsapplication.presentation.Dimensions
import com.learn.newsapplication.presentation.common.ArticleList
import com.learn.newsapplication.presentation.common.SearchBar
import com.learn.newsapplication.presentation.navgraph.Route

@Composable
fun SearchScreen(
    state: SearchState,
    event: (SearchEvent) -> Unit,
    navigate:(String) -> Unit
) {

    Column(
        modifier = Modifier
            .padding(
                top = Dimensions.MediumPaddingFirst,
                start = Dimensions.MediumPaddingFirst,
                end = Dimensions.MediumPaddingFirst
            )
            .statusBarsPadding()
    ) {
        SearchBar(
            text = state.searchQuery,
            readOnly = false,
            onValueChange = { event(SearchEvent.UpdateSearch(it)) },
            onSearch = { event(SearchEvent.SearchNews) }
        )

        Spacer(modifier = Modifier.height(Dimensions.MediumPaddingFirst))

        state.articles?.let {
            val articles = it.collectAsLazyPagingItems()
            ArticleList(articles = articles, onClick = { navigate(Route.SearchScreen.route)} )
        }

    }

}