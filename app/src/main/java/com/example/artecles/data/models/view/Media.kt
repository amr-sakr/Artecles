package com.example.artecles.data.models.view

import com.example.artecles.data.models.network.MediaApi

data class Media(
    val mediaMetadata: List<MediaData> = listOf(),
)

fun MediaApi.toMedia() =
    Media(
        mediaMetadata = mediaMetadata?.map { it.toMediaData() } ?: listOf()
    )