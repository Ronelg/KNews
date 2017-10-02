package com.knews.android.data.source.local

import android.content.Context
import com.knews.android.data.source.NewsDataSource
import com.knews.android.model.ArticlesResponse
import com.knews.android.model.SourcesResponse
import io.reactivex.Observable

/**
 * Created by ronelg on 10/2/17.
 */
class NewsLocalDataSource(context: Context) : NewsDataSource {

    companion object {
        private lateinit var INSTANCE: NewsLocalDataSource
        private var needsNewInstance = true

        @JvmStatic
        fun getInstance(context: Context): NewsLocalDataSource {
            if (needsNewInstance) {
                INSTANCE = NewsLocalDataSource(context)
                needsNewInstance = false
            }
            return INSTANCE
        }
    }

    override fun getSources(): Observable<List<SourcesResponse>> {
        return Observable.empty()
    }

    override fun getArticles(): Observable<List<ArticlesResponse>> {
        return Observable.empty()
    }
}