package com.learn.newsapplication.presentation.onboarding

import androidx.annotation.DrawableRes
import com.learn.newsapplication.R

data class Page(
    val title: String,
    val description: String,
    @DrawableRes val image: Int
)


val pages = listOf(
    Page(
        title = " Welcome to Everyday Refresh",
        description = " Lorem Ipsum has been the industry's standard dummy text ever since 1500's.",
        image = R.drawable.onboarding1
    ),
    Page(
        title = "It is a dummy platform.",
        description = " Lorem Ipsum has been the industry's standard dummy text ever since 1500's.",
        image = R.drawable.onboarding2
    ),
    Page(
        title = "Pleased to have you onboard.",
        description = " Lorem Ipsum has been the industry's standard dummy text ever since 1500's.",
        image = R.drawable.onboarding3
    ),
)
