package com.example.manolofernandez.te2.service

import com.example.manolofernandez.te2.model.ImagesResponse

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by manolofernandez on 4/1/18.
 */

interface API {
    companion object {
        val BASE_URL = "http://api.flickr.com"
        val FORMAT = "json"
    }

    @GET("/services/feeds/photos_public.gne?tags=kitten")
    fun getTopTwentyHottestQuestions(@Query("format") format: String,
                                     @Query("nojsoncallback") value: Int): Call<ImagesResponse>

}
