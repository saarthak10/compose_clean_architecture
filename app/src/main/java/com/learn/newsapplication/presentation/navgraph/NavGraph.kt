package com.learn.newsapplication.presentation.navgraph

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import androidx.paging.compose.collectAsLazyPagingItems
import com.learn.newsapplication.presentation.home.HomeScreen
import com.learn.newsapplication.presentation.home.HomeViewModel
import com.learn.newsapplication.presentation.onboarding.OnBoardingScreen
import com.learn.newsapplication.presentation.onboarding.OnBoardingViewModel
import com.learn.newsapplication.presentation.search.SearchScreen
import com.learn.newsapplication.presentation.search.SearchViewModel


@Composable
fun NavGraph(
    startDestination: String
){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination= startDestination){
        navigation(
            route = Route.AppStartNavigation.route,
            startDestination = Route.OnBoardingScreen.route,
        ){
            composable(
                route = Route.OnBoardingScreen.route
            ){
                val viewModel: OnBoardingViewModel = hiltViewModel()
                OnBoardingScreen(
                    event = viewModel::onEvent
                )
            }
        }

        navigation(
            route = Route.NewsNavigation.route,
            startDestination = Route.NewsNavigatorScreen.route
        ){
           composable(
               route = Route.NewsNavigatorScreen.route
           ) {
               val viewModel:SearchViewModel = hiltViewModel()
               //val articles = viewModel.searchState.collectAsLazyPagingItems()
               //HomeScreen(articles = articles, navigate = {})
               SearchScreen(state = viewModel.searchState.value, event = viewModel::onEvent , navigate ={} )
           }
        }
    }

}