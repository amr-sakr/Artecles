package com.example.artecles.data.models.network


import com.google.gson.annotations.SerializedName

data class MediaApi(
    @SerializedName("approved_for_syndication")
    val approvedForSyndication: Int? = null,
    @SerializedName("caption")
    val caption: String? = null,
    @SerializedName("copyright")
    val copyright: String? = null,
    @SerializedName("media-metadata")
    val mediaMetadata: List<MediaMetadataApi>? = null,
    @SerializedName("subtype")
    val subtype: String? = null,
    @SerializedName("type")
    val type: String? = null
)