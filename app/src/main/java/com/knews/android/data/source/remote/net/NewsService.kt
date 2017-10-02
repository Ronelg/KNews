package com.knews.android.data.source.remote.net

import com.knews.android.data.SortBy
import com.knews.android.model.ArticlesResponse
import com.knews.android.model.SourcesResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author moshe on 2017/10/02.
 */
interface NewsService {

    @GET("sources")
    fun getSources(@Query("category") category: String?,
                   @Query("language") language: String?,
                   @Query("country") country: String?): SourcesResponse

    @GET("articles")
    fun getNewsApi(@Query("source") source: String,
                   @Query("apiKey") apiKey: String,
                   @Query("sortBy") sortBy: SortBy? = SortBy.TOP): ArticlesResponse
}