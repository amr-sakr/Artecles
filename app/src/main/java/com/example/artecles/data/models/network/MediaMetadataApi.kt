package com.example.artecles.data.models.network


import com.google.gson.annotations.SerializedName

data class MediaMetadataApi(
    @SerializedName("format")
    val format: String? = null,
    @SerializedName("height")
    val height: Int? = null,
    @SerializedName("url")
    val url: String? = null,
    @SerializedName("width")
    val width: Int? = null
)