package com.example.manolofernandez.te2.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by manolofernandez on 4/1/18.
 */

class Item {

    @SerializedName("title")
    @Expose
    var title: String? = null
    @SerializedName("link")
    @Expose
    var link: String? = null
    @SerializedName("media")
    @Expose
    var media: Media? = null
    @SerializedName("date_taken")
    @Expose
    var dateTaken: String? = null
    @SerializedName("description")
    @Expose
    var description: String? = null
    @SerializedName("published")
    @Expose
    var published: String? = null
    @SerializedName("author")
    @Expose
    var author: String? = null
    @SerializedName("author_id")
    @Expose
    var authorId: String? = null
    @SerializedName("tags")
    @Expose
    var tags: String? = null

}
