package com.example.hc2023

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserModel(
    @Json(name = "id") val id : Int,
    @Json(name = "name") val name : String,
    @Json(name = "phone_number") val phone_number : String,
    @Json(name = "rides_going") val rides_going : List<RideModel>,
    @Json(name = "rides_giving") val rides_giving : List<RideModel>,
    @Json(name = "email") val email : List<String>,
    @Json(name = "session_token") val session_token : String,
    @Json(name = "session_expiration") val session_expiration : String,
    @Json(name = "update_token") val update_token : String
    )

@JsonClass(generateAdapter = true)
data class RidesModel(
    @Json(name = "rides") val rides : List<RideModel>
)

@JsonClass(generateAdapter = true)
data class RideModel(
    @Json(name = "id") val id : Int,
    @Json(name = "destination") val destination : String,
    @Json(name = "time") val time : String,
    @Json(name = "driver") val driver : UserSimpleModel,
    @Json(name = "passengers") val passengers : List<UserSimpleModel>,
    @Json(name = "payment") val payment : String,
    @Json(name = "additional_info") val additional_info : String,
    @Json(name = "seats_open") val seats_open : Int,
    @Json(name = "is_completed") val is_completed : Boolean
    )

@JsonClass(generateAdapter = true)
data class UserSimpleModel(
    @Json(name = "id") val id : Int,
    @Json(name = "name") val name : String,
    @Json(name = "phone_number") val phone_number : String
)
