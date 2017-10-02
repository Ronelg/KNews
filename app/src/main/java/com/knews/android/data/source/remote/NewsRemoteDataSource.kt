package com.knews.android.data.source.remote

import com.knews.android.BuildConfig
import com.knews.android.data.Article
import com.knews.android.data.Source
import com.knews.android.data.source.NewsDataSource
import com.knews.android.data.source.remote.net.NetworkModule
import com.knews.android.data.source.remote.net.NewsService
import io.reactivex.Observable
import java.util.*
import javax.inject.Inject

/**
 * Created by ronelg on 10/2/17.
 */
class NewsRemoteDataSource : NewsDataSource {

    @Inject
    lateinit var service: NewsService

    init {
        //FIXME DaggerNewsComponent.builder().build().inject(this)
        val net = NetworkModule()
        val retrofit = net.provideRetrofit()
        service = net.provideNewsService(retrofit)
    }

    override fun getSources(): Observable<List<Source>> {
        val locale = Locale.getDefault()
        val response = service.getSources(null, locale.language, locale.country)
        //TODO check that response.status is OK
        return response.map { it.sources }
    }

    override fun getArticles(source: Source?): Observable<List<Article>> {
        if (source == null) {
            return Observable.empty()
        }
        //TODO check that response.status is OK
        val response = service.getArticles(source.id, BuildConfig.NEWS_API_KEY)
        return response.map { it.articles }
    }

    companion object {
        private lateinit var INSTANCE: NewsRemoteDataSource
        private var needsNewInstance = true

        @JvmStatic
        fun getInstance(): NewsRemoteDataSource {
            if (needsNewInstance) {
                INSTANCE = NewsRemoteDataSource()
                needsNewInstance = false
            }
            return INSTANCE
        }
    }
}