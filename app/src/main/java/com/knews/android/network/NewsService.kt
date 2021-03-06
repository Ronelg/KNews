package com.knews.android.network

import com.knews.android.data.Source.SortBy
import com.knews.android.model.ArticlesResponse
import com.knews.android.model.SourcesResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author moshe on 2017/10/02.
 */
interface NewsService {

    @GET("sources")
    fun getSources(@Query("category") category: String?,
                   @Query("language") language: String?,
                   @Query("country") country: String?): Observable<SourcesResponse>

    @GET("articles")
    fun getArticles(@Query("source") source: String,
                    @Query("apiKey") apiKey: String,
                    @Query("sortBy") sortBy: SortBy? = SortBy.TOP): Observable<ArticlesResponse>
}