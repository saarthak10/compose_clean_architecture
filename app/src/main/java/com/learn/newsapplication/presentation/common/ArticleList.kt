package com.learn.newsapplication.presentation.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.learn.newsapplication.domain.model.Article
import com.learn.newsapplication.presentation.Dimensions

@Composable
fun ArticleList(
    modifier: Modifier = Modifier,
    articles: LazyPagingItems<Article>,
    onClick: (Article) -> Unit
) {
    val handlePagingResult = handlePagingResult(article = articles)
    if (handlePagingResult){
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(Dimensions.MediumPaddingFirst),
            contentPadding = PaddingValues(all = Dimensions.ExtraSmallPaddingFirst),
        ){
            items(count = articles.itemCount){ articleItem ->
                articles[articleItem]?.let{
                    ArticleCard(article = it, onClick = {onClick(it)})
                }
            }
        }
    }
}


@Composable
fun handlePagingResult(
    article: LazyPagingItems<Article>
): Boolean {
    val loadState = article.loadState
    val error = when{
        loadState.refresh is LoadState.Error -> loadState.refresh as LoadState.Error
        loadState.prepend is LoadState.Error -> loadState.prepend as LoadState.Error
        loadState.append is LoadState.Error -> loadState.append as LoadState.Error
        else -> null
    }

    return when{
        loadState.refresh is LoadState.Loading ->{
            ShimmerEffect()
            false
        }
        error != null ->{
            EmptyScreen()
            false
        }
        else->{
            true
        }
    }
}


@Composable
private fun ShimmerEffect(){
    Column(verticalArrangement = Arrangement.spacedBy(Dimensions.MediumPaddingFirst)) {
            repeat(10){
                ArticleCardShimmer(
                    modifier = Modifier.padding(Dimensions.MediumPaddingFirst)
                )
            }
    }
}