package com.example.hc2023

import android.util.Log
import androidx.fragment.app.FragmentActivity
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import okhttp3.*
import java.io.IOException

fun getPastRides(activity: FragmentActivity, callback: (List<RideModel>) -> Unit) {
    val resources = activity.resources
    val queryUrl = resources.getString(R.string.get_past_rides_url)
    Log.d("JOEY", queryUrl)

    val client = OkHttpClient()
    val request = Request.Builder()
        .url(queryUrl)
        .get()
        .build()

    client.newCall(request).enqueue(object: Callback {
        override fun onFailure(call: Call, e: IOException) {
            Log.d("JOEY", "FAIL")
            e.printStackTrace()
        }

        override fun onResponse(call: Call, response: Response) {
            if (!response.isSuccessful) {
                // Can also respond with some UI saying check internet, try again, network request failed,
                // etc. as opposed to exception (which will crash your app unless caught)!
                Log.d("JOEY", "RESPONSE FAIL")
                throw IOException("Unexpected code $response")
            } else {
                Log.d("JOEY", "RESPONSE SUCCESS")
                val body = response.body

                // Creates a List<Post> type to adapt from
//                val type = Types.newParameterizedType(
//                    List::class.java, //List:class.java must come first!
//                    RidesModel::class.java
//                )

                //TODO: integrate w/ backend
                val moshi: Moshi = Moshi.Builder().build()
//                val adapter = moshi.adapter<List<RidesModel>>(type)
//                val rides : List<RideModel>? = if (body != null) adapter.fromJson(body.source()) else listOf()

                val adapter = moshi.adapter<UserModel>(UserModel::class.java)
                val userModel : UserModel? = if (body != null) adapter.fromJson(body.source()) else null

                activity.runOnUiThread {
                    if (userModel != null) {
                        callback(userModel.rides_giving)
                    }
                }
            }
        }

    })
}

fun getAllRides(activity: FragmentActivity, callback: (List<RideModel>) -> Unit) {
    val resources = activity.resources
    val queryUrl = resources.getString(R.string.get_all_rides_url)
    Log.d("JOEY", queryUrl)

    val client = OkHttpClient()
    val request = Request.Builder()
        .url(queryUrl)
        .get()
        .build()

    client.newCall(request).enqueue(object: Callback {
        override fun onFailure(call: Call, e: IOException) {
            Log.d("JOEY", "FAIL")
            e.printStackTrace()
        }

        override fun onResponse(call: Call, response: Response) {
            if (!response.isSuccessful) {
                // Can also respond with some UI saying check internet, try again, network request failed,
                // etc. as opposed to exception (which will crash your app unless caught)!
                Log.d("JOEY", "RESPONSE FAIL")
                throw IOException("Unexpected code $response")
            } else {
                Log.d("JOEY", "RESPONSE SUCCESS")
                val body = response.body

                // Creates a List<Post> type to adapt from
//                val type = Types.newParameterizedType(
//                    List::class.java, //List:class.java must come first!
//                    RidesModel::class.java
//                )

                //TODO: integrate w/ backend
                val moshi: Moshi = Moshi.Builder().build()
//                val adapter = moshi.adapter<List<RidesModel>>(type)
//                val rides : List<RideModel>? = if (body != null) adapter.fromJson(body.source()) else listOf()

                val adapter = moshi.adapter<RidesModel>(RidesModel::class.java)
                val ridesModel : RidesModel? = if (body != null) adapter.fromJson(body.source()) else null

                activity.runOnUiThread {
                    if (ridesModel != null) {
                        callback(ridesModel.rides)
                    }
                }
            }
        }

    })
}