package com.knews.android.data.source.remote

import android.content.Context
import com.knews.android.data.source.NewsDataSource
import com.knews.android.data.source.remote.net.NetworkModule
import com.knews.android.data.source.remote.net.NewsService
import com.knews.android.model.ArticlesResponse
import com.knews.android.model.SourcesResponse
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by ronelg on 10/2/17.
 */
class NewsRemoteDataSource(context: Context) : NewsDataSource {

    @Inject
    lateinit var service: NewsService

    init {
        //FIXME DaggerNewsComponent.builder().build().inject(this)
        val net = NetworkModule()
        val retrofit = net.provideRetrofit()
        service = net.provideNewsService(retrofit)
    }

    override fun getSources(): Observable<List<SourcesResponse>> {
        return Observable.empty()
    }

    override fun getArticles(): Observable<List<ArticlesResponse>> {
        return Observable.empty()
    }

    companion object {
        private lateinit var instance: NewsRemoteDataSource
        private var needsNewInstance = true

        @JvmStatic
        fun getInstance(context: Context): NewsRemoteDataSource {
            if (needsNewInstance) {
                instance = NewsRemoteDataSource(context)
                needsNewInstance = false
            }
            return instance
        }
    }
}