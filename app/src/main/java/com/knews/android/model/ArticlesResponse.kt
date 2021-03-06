package com.knews.android.model

import com.google.gson.annotations.SerializedName
import com.knews.android.data.Article
import com.knews.android.data.Source.SortBy

/**
 * Created by ronelg on 10/2/17.
 */
class ArticlesResponse(
        @SerializedName("status")
        val status: String,
        @SerializedName("source")
        val source: String,
        @SerializedName("sortBy")
        val sortBy: SortBy,
        @SerializedName("articles")
        val articles: List<Article>) {

}