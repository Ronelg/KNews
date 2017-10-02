package com.knews.android.data.source.local

import android.content.Context
import com.knews.android.data.Article
import com.knews.android.data.Source
import com.knews.android.data.source.NewsDataSource
import io.reactivex.Observable

/**
 * Created by ronelg on 10/2/17.
 */
class NewsLocalDataSource(context: Context) : NewsDataSource {


    override fun getSources(): Observable<List<Source>> {
        return Observable.empty()
    }

    override fun getArticles(sourceId: String): Observable<List<Article>> {
        return Observable.empty()
    }

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
}