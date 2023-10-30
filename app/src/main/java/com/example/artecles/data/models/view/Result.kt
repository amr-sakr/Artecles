package com.example.artecles.data.models.view

import com.example.artecles.data.models.network.ResultApi

data class Result(
    val id: Long = -1L,
    val media: List<Media> = listOf(),
    val title: String = "",
    val type: String = "",
    val url: String = ""
)

fun ResultApi.toResulApi() =
    Result(
        id = id ?: -1,
        media = media?.map { it.toMedia() } ?: listOf(),
        title = title ?: "",
        type = type ?: "",
        url = url ?: ""
    )