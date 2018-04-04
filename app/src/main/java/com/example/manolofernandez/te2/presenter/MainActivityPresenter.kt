package com.example.manolofernandez.te2.presenter

import com.example.manolofernandez.te2.model.ImagesResponse
import com.example.manolofernandez.te2.model.Item
import com.example.manolofernandez.te2.service.API
import com.example.manolofernandez.te2.view.MainActivityView
import com.google.gson.Gson
import com.google.gson.GsonBuilder

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by manolofernandez on 4/1/18.
 */

class MainActivityPresenter(private val mainActivityView: MainActivityView) : Presenter {
    private var serviceCall: API? = null
    private var itemList: List<Item>? = null

    override fun getImagesList() {
        createFlickrAPI()

        val responseCall = serviceCall!!.getTopTwentyHottestQuestions(API.FORMAT, 1)

        responseCall.enqueue(object : Callback<ImagesResponse> {
            override fun onResponse(call: Call<ImagesResponse>, response: Response<ImagesResponse>?) {
                if (response != null && response.body() != null) {
                    itemList = response.body().items
                    mainActivityView.showImagesList(itemList!!)
                } else {
                    mainActivityView.showCallFailed()
                }
            }

            override fun onFailure(call: Call<ImagesResponse>, t: Throwable) {
                mainActivityView.showCallFailed()
            }
        })

    }

    private fun createFlickrAPI() {
        val gson = GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .setLenient()
                .create()

        val retrofit = Retrofit.Builder()
                .baseUrl(API.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()

        serviceCall = retrofit.create<API>(API::class.java!!)
    }
}
