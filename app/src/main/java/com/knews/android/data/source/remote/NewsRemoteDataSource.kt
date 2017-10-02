package com.knews.android.data.source.remote

import android.content.Context
import com.knews.android.data.source.NewsDataSource
import com.knews.android.model.ArticlesResponse
import com.knews.android.model.SourcesResponse
import io.reactivex.Observable

/**
 * Created by ronelg on 10/2/17.
 */
class NewsRemoteDataSource(context: Context) : NewsDataSource {

    override fun getSources(): Observable<List<SourcesResponse>> {
        return Observable.empty()
    }

    override fun getArticles(): Observable<List<ArticlesResponse>> {
        return Observable.empty()
    }

    companion object {
        private lateinit var INSTANCE: NewsRemoteDataSource
        private var needsNewInstance = true

        @JvmStatic
        fun getInstance(context: Context): NewsRemoteDataSource {
            if (needsNewInstance) {
                INSTANCE = NewsRemoteDataSource(context)
                needsNewInstance = false
            }
            return INSTANCE
        }
    }
}