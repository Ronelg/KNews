package com.knews.android.data

import com.google.gson.annotations.SerializedName
import java.util.Calendar

/**
 * Created by ronelg on 10/2/17.
 */
data class Article(
        @SerializedName("author")
        val author: String? = null,
        @SerializedName("title")
        val title: String? = null,
        @SerializedName("description")
        val description: String? = null,
        @SerializedName("url")
        val url: String? = null,
        @SerializedName("urlToImage")
        val image: String? = null,
        @SerializedName("publishedAt")
        val publishedAt: Calendar? = null) {
}