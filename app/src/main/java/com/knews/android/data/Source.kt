package com.knews.android.data

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * Created by ronelg on 10/2/17.
 */
@Entity(tableName = "sources")
data class Source(
        @SerializedName("id")
        @PrimaryKey
        @ColumnInfo(name = "id")
        val id: String,
        @SerializedName("name")
        @ColumnInfo(name = "name")
        val name: String? = null,
        @SerializedName("description")
        @ColumnInfo(name = "description")
        val description: String? = null,
        @SerializedName("url")
        @ColumnInfo(name = "url")
        val url: String? = null,
        @SerializedName("category")
        @ColumnInfo(name = "category")
        val category: String? = null,
        @SerializedName("language")
        @ColumnInfo(name = "language")
        val language: String? = null,
        @SerializedName("country")
        @ColumnInfo(name = "country")
        val country: String? = null,
        @Ignore
        @SerializedName("sortBysAvailable")
        val sortBysAvailable: List<SortBy>? = null) {

    fun getLogo(): String {
        return "https://icons.better-idea.org/icon?url=$url&amp;size=70..120..200"
    }

    enum class SortBy {
        @SerializedName("top")
        TOP,
        @SerializedName("latest")
        LATEST,
        @SerializedName("popular")
        POPULAR
    }
}