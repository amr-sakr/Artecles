package com.example.artecles.data.models.view

import com.example.artecles.data.models.network.MediaMetadataApi

data class MediaData(
    val url: String? = null,
    val format: String? = null,
)

fun MediaMetadataApi.toMediaData() =
    MediaData(
        url = url,
        format = format
    )