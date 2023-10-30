package com.example.artecles.data.models.network


import com.google.gson.annotations.SerializedName

data class ArticlesResponse(
    @SerializedName("copyright")
    val copyright: String? = null,
    @SerializedName("num_results")
    val numResults: Int? = null,
    @SerializedName("results")
    val results: List<ResultApi>? = null,
    @SerializedName("status")
    val status: String? = null
)