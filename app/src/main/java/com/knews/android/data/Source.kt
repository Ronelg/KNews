package com.knews.android.data

import com.google.gson.annotations.SerializedName

/**
 * Created by ronelg on 10/2/17.
 */
data class Source(
        @SerializedName("id")
        val id: String,
        @SerializedName("name")
        val name: String? = null,
        @SerializedName("description")
        val description: String? = null,
        @SerializedName("url")
        val url: String? = null,
        @SerializedName("category")
        val category: String? = null,
        @SerializedName("language")
        val language: String? = null,
        @SerializedName("country")
        val country: String? = null,
        @SerializedName("urlToLogos")
        val urlToLogos: UrlToLogos? = null) {
}

data class UrlToLogos(
        @SerializedName("small")
        val small: String? = null,
        @SerializedName("medium")
        val medium: String? = null,
        @SerializedName("large")
        val large: String? = null) {

}