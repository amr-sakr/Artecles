package com.example.artecles.data.api

import com.example.artecles.BuildConfig
import com.example.artecles.costants.PATH_MOST_VIEWED
import com.example.artecles.costants.PATH_SECTIONS
import com.example.artecles.data.models.network.ArticlesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ArticlesAPI {

//    https://api.nytimes.com/svc/mostpopular/v2/mostviewed/all-sections/1.json?api-key=d4q1Mr1Or4Am6rhoHuvtpkqE2gDp211P

    @GET("${BuildConfig.BASE_URL}/$PATH_MOST_VIEWED/$PATH_SECTIONS/{period}")
    suspend fun getArticles(
        @Path("period") period: Int,
        @Query("api-key") apiKey: String
    ): Response<ArticlesResponse>
}