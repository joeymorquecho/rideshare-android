package com.example.hc2023

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PostModel(
    @Json(name = "title") val title : String,
    @Json(name = "body") val body : String,
    @Json(name = "hashedPoster") val hashedPoster : String,
    @Json(name = "timestamp") val timestamp : String,
    @Json(name = "id") val id : Int
    )
