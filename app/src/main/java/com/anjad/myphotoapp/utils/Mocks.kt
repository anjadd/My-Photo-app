package com.anjad.myphotoapp.utils

import com.anjad.myphotoapp.model.FlickrImage
import java.time.ZoneId
import java.time.ZonedDateTime

fun generateMockImageList(): List<FlickrImage> = listOf(
    FlickrImage(
        title = "Maldives",
        author = "Jean Michel",
        dateTaken = ZonedDateTime.of(2011, 2, 22, 12, 0, 0, 0, ZoneId.systemDefault()),
        description = null,
        link = "",
        thumbnailImage = "beach_1",
        bigImage = "",
        listOfTags = listOf()
    ),
    FlickrImage(
        title = "Some beach",
        author = "Cuba Gallery",
        dateTaken = ZonedDateTime.of(2018, 5, 7, 12, 0, 0, 0, ZoneId.systemDefault()),
        description = null,
        link = "",
        thumbnailImage = "beach_2",
        bigImage = "",
        listOfTags = listOf()
    ),
    FlickrImage(
        title = "Beach coast",
        author = "Danny Vb",
        dateTaken = ZonedDateTime.of(2014, 10, 27, 12, 0, 0, 0, ZoneId.systemDefault()),
        description = null,
        link = "",
        thumbnailImage = "beach_3",
        bigImage = "",
        listOfTags = listOf()
    ),
    FlickrImage(
        title = "Blue beach",
        author = "Renemz",
        dateTaken = ZonedDateTime.of(2022, 6, 10, 12, 0, 0, 0, ZoneId.systemDefault()),
        description = null,
        link = "",
        thumbnailImage = "beach_4",
        bigImage = "",
        listOfTags = listOf()
    ),
    FlickrImage(
        title = "Beachh",
        author = "Michaela55",
        dateTaken = ZonedDateTime.of(2016, 3, 2, 12, 0, 0, 0, ZoneId.systemDefault()),
        description = null,
        link = "",
        thumbnailImage = "beach_5",
        bigImage = "",
        listOfTags = listOf()
    ),
    FlickrImage(
        title = "Sunset beach",
        author = "Bianca12",
        dateTaken = ZonedDateTime.of(2018, 5, 7, 12, 0, 0, 0, ZoneId.systemDefault()),
        description = null,
        link = "",
        thumbnailImage = "beach_6",
        bigImage = "",
        listOfTags = listOf()
    ),
)