package com.example.testaufgabe.data.remote.dto

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SWPageDto(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<Map<String, Any?>>
)
