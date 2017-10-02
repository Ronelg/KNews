package com.knews.android.data

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import com.google.gson.annotations.SerializedName
import java.util.*

/**
 * Created by ronelg on 10/2/17.
 */
@Entity(tableName = "articles")
data class Article(
        @SerializedName("author")
        @ColumnInfo(name = "author")
        val author: String? = null,
        @ColumnInfo(name = "title")
        @SerializedName("title")
        val title: String? = null,
        @ColumnInfo(name = "description")
        @SerializedName("description")
        val description: String? = null,
        @ColumnInfo(name = "url")
        @SerializedName("url")
        val url: String? = null,
        @ColumnInfo(name = "urlToImage")
        @SerializedName("urlToImage")
        val imageUrl: String? = null,
        @ColumnInfo(name = "publishedAt")
        @SerializedName("publishedAt")
        val publishedAt: String? = null) {
}