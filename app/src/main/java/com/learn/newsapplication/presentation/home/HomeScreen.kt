package com.learn.newsapplication.presentation.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import com.learn.newsapplication.R
import com.learn.newsapplication.domain.model.Article
import com.learn.newsapplication.presentation.Dimensions
import com.learn.newsapplication.presentation.common.ArticleList
import com.learn.newsapplication.presentation.common.SearchBar
import com.learn.newsapplication.presentation.navgraph.Route

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    articles: LazyPagingItems<Article>,
    navigate: (String) -> Unit
) {
    val titles by remember {
        derivedStateOf {
            if (articles.itemCount > 10) {
                articles.itemSnapshotList.items
                    .slice(IntRange(0, 9))
                    .joinToString(separator = "\uD83d\uDFE5 ") { it.title }
            } else {
                " "
            }
        }
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = Dimensions.MediumPaddingFirst)
            .statusBarsPadding()
    ) {
        Image(
            painter = painterResource(id = R.drawable.img_news_logo), contentDescription = null,
            modifier = Modifier
                .width(150.dp)
                .height(30.dp)
                .padding(horizontal = Dimensions.MediumPaddingFirst)
        )

        Spacer(modifier = Modifier.height(Dimensions.MediumPaddingFirst))
        SearchBar(
            text = "",
            readOnly = true,
            onValueChange = {},
            onClick = { navigate(Route.SearchScreen.route) },
            onSearch = {})

        Spacer(modifier = Modifier.height(Dimensions.MediumPaddingFirst))

        Text(
            text = titles,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = Dimensions.MediumPaddingFirst)
                .basicMarquee(),
            color = colorResource(id = R.color.placeholder)
        )
        
        ArticleList( articles = articles, onClick ={
            navigate(Route.DetailsScreen.route)
        } )

    }

}