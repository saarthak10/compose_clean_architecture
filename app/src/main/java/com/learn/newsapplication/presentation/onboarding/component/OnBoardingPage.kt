package com.learn.newsapplication.presentation.onboarding.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.learn.newsapplication.R
import com.learn.newsapplication.presentation.Dimensions
import com.learn.newsapplication.presentation.onboarding.Page
import com.learn.newsapplication.presentation.onboarding.pages
import com.learn.newsapplication.ui.theme.NewsApplicationTheme

@Composable
fun OnBoardingPage(
    modifier:Modifier = Modifier,
    page:Page
){

    Column(modifier = modifier) {
       Image( modifier = Modifier
           .fillMaxWidth()
           .fillMaxHeight(fraction = 0.6f),
           painter = painterResource(id = page.image),
           contentDescription = null,
           contentScale = ContentScale.Crop
           )
        
        Spacer(modifier = Modifier.height(Dimensions.MediumPaddingFirst))
        
        Text(text = page.title,
            modifier = Modifier.padding(horizontal = Dimensions.MediumPaddingFirst),
            style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.Bold),
            color =  colorResource(id = R.color.display_small)
        )

        Text(text = page.description,
            modifier = Modifier.padding(horizontal = Dimensions.MediumPaddingFirst),
            style = MaterialTheme.typography.bodyMedium,
            color =  colorResource(id = R.color.text_medium)
        )

    }

}

