package com.knews.android.data

/**
 * Created by ronelg on 10/2/17.
 */
data class Source(val id: String,
        val name: String? = null,
        val description: String? = null,
        val url: String? = null,
        val category: String? = null,
        val language: String? = null,
        val country: String? = null,
        val urlToLogos: UrlToLogos? = null) {
}

data class UrlToLogos(val small: String? = null,
        val medium: String? = null,
        val large: String? = null) {

}