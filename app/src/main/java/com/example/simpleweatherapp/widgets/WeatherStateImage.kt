package com.example.simpleweatherapp.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.CachePolicy
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation

@Composable
fun WeatherStateImage(imageUrl: String) {

    Image(
        modifier = Modifier.size(60.dp), painter = rememberAsyncImagePainter(
            model = ImageRequest.Builder(LocalContext.current).data(imageUrl)
                .transformations(CircleCropTransformation()).crossfade(true)
                .diskCacheKey("data_image_${imageUrl}").networkCachePolicy(CachePolicy.ENABLED)
                .diskCachePolicy(CachePolicy.DISABLED).memoryCachePolicy(CachePolicy.ENABLED)
                .build(),
            contentScale = ContentScale.Crop,
            filterQuality = FilterQuality.None,
        ), alignment = Alignment.BottomStart, contentDescription = "image"
    )

}