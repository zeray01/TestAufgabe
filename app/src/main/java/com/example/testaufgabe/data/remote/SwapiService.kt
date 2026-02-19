package com.example.testaufgabe.data.remote

import com.example.testaufgabe.data.remote.dto.SWPageDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface SwapiService {

    @GET("{resource}")
    suspend fun getResourcePage(
        @Path("resource") resource: String,
        @Query("page") page: Int? = null
    ): Response<SWPageDto>
}
