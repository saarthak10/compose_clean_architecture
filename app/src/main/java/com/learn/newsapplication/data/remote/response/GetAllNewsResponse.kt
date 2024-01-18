package com.learn.newsapplication.data.remote.response


import com.google.gson.annotations.SerializedName
import com.learn.newsapplication.domain.model.Article
import java.io.Serializable

data class GetAllNewsResponse(
    @SerializedName("articles")
    val articles: List<Article>,
    @SerializedName("status")
    val status: String,
    @SerializedName("totalResults")
    val totalResults: Int
)