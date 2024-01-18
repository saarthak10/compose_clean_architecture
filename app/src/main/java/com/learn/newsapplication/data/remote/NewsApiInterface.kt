package com.learn.newsapplication.data.remote

import com.learn.newsapplication.data.remote.response.GetAllNewsResponse
import com.learn.newsapplication.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiInterface {

    @GET("everything")
    suspend fun getNews(
        @Query("apiKey") apiKey:String = Constants.NEWS_API_KEY,
        @Query("sources") sources:String,
        @Query("page") page:Int
    ):GetAllNewsResponse
}