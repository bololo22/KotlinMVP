package com.example.manolofernandez.te2.model

/**
 * Created by manolofernandez on 4/1/18.
 */

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ImagesResponse {

    @SerializedName("title")
    @Expose
    var title: String? = null
    @SerializedName("link")
    @Expose
    var link: String? = null
    @SerializedName("description")
    @Expose
    var description: String? = null
    @SerializedName("modified")
    @Expose
    var modified: String? = null
    @SerializedName("generator")
    @Expose
    var generator: String? = null
    @SerializedName("items")
    @Expose
    var items: List<Item>? = null

}