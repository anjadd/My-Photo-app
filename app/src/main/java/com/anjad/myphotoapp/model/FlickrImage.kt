package com.anjad.myphotoapp.model

import java.time.ZonedDateTime

data class FlickrImage(
    val title: String,
    val author: String,
    val dateTaken: ZonedDateTime,
    val description: String? = null,
    val link: String,
    val thumbnailImage: String,
    val bigImage: String,
    val listOfTags: List<String>,
)
