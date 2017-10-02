package com.knews.android.data.source

import com.knews.android.data.source.local.NewsLocalDataSource
import com.knews.android.data.source.remote.NewsRemoteDataSource
import com.knews.android.model.ArticlesResponse
import com.knews.android.model.SourcesResponse
import io.reactivex.Observable

/**
 * Created by ronelg on 10/2/17.
 */
class NewsRepository(private val newsRemoteDataSource: NewsRemoteDataSource,
                     private val newsLocalDataSource: NewsLocalDataSource) : NewsDataSource {


    override fun getSources(): Observable<List<SourcesResponse>> {
        return Observable.empty()
    }

    override fun getArticles(): Observable<List<ArticlesResponse>> {
        return newsRemoteDataSource.getArticles()
    }

    companion object {
        private lateinit var INSTANCE: NewsRepository
        private var needsNewInstance = true

        @JvmStatic
        fun getInstance(newsRemoteDataSource: NewsRemoteDataSource,
                        newsLocalDataSource: NewsLocalDataSource): NewsRepository {
            if (needsNewInstance) {
                INSTANCE = NewsRepository(newsRemoteDataSource, newsLocalDataSource)
                needsNewInstance = false
            }
            return INSTANCE
        }
    }
}