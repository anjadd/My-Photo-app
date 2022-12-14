package com.anjad.myphotoapp.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.anjad.myphotoapp.R
import com.anjad.myphotoapp.model.FlickrImage
import com.anjad.myphotoapp.ui.theme.MyPhotoAppTheme
import com.anjad.myphotoapp.utils.generateMockImageList

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    imageList: List<FlickrImage>,
    onImageClick: (FlickrImage) -> Unit,
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(MyPhotoAppTheme.dimensions.paddingDefault),
        verticalArrangement = Arrangement.spacedBy(MyPhotoAppTheme.dimensions.paddingSmall),
    ) {
        items(imageList) { item ->
            PhotoCard(
                item = item,
                onImageClick = onImageClick,
            )
        }
    }
}

@Composable
fun PhotoCard(
    item: FlickrImage,
    modifier: Modifier = Modifier,
    onImageClick: (FlickrImage) -> Unit,
) {
    val context = LocalContext.current

    Card(
        elevation = 10.dp,
        shape = MaterialTheme.shapes.medium,
        modifier = modifier
            .fillMaxWidth()
            .clickable {
                onImageClick(item)
            }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(MyPhotoAppTheme.dimensions.paddingSmall)
        ) {
            val imageData = item.link
            val imageRequest = ImageRequest.Builder(context)
                .data(imageData)
                .crossfade(false)
                .build()
            AsyncImage(
                model = imageRequest,
                contentDescription = stringResource(id = R.string.flickr_image),
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(180.dp),
                placeholder = painterResource(id = R.drawable.ic_loading),
                error = painterResource(R.drawable.ic_empty_image_placeholder),
            )
            Column {
                Text(text = item.title, style = MaterialTheme.typography.h6)
                Text(text = item.author, style = MaterialTheme.typography.body2)
            }
        }
    }
}

@Composable
fun LoadingState(isLoading: Boolean, modifier: Modifier = Modifier) {
    if (isLoading) {
        Box(modifier = modifier.fillMaxSize()) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}

@Composable
fun ErrorState(
    errorMessage: String?,
    onRetryClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = errorMessage ?: stringResource(id = R.string.error_message),
            style = MaterialTheme.typography.body1
        )
        Button(onClick = onRetryClick) {
            Text(text = stringResource(id = R.string.retry))
        }
    }
}

@Preview(name = "MainScreen", showBackground = true, device = Devices.DEFAULT)
@Composable
fun MainScreenPreview() {
    MyPhotoAppTheme {
        MainScreen(modifier = Modifier, imageList = generateMockImageList(), onImageClick = {})
    }
}

@Preview(name = "LoadingState", showBackground = true, device = Devices.DEFAULT)
@Composable
fun LoadingStatePreview() {
    MyPhotoAppTheme {
        LoadingState(isLoading = true)
    }
}

@Preview(name = "ErrorState", showBackground = true, device = Devices.DEFAULT)
@Composable
fun ErrorStatePreview() {
    MyPhotoAppTheme {
        ErrorState(errorMessage = null, onRetryClick = {})
    }
}