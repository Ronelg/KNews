package com.knews.android.data.source.local

import com.knews.android.data.source.NewsDataSource
import com.knews.android.model.ArticlesResponse
import com.knews.android.model.SourcesResponse
import io.reactivex.Observable

/**
 * Created by ronelg on 10/2/17.
 */
class NewsLocalDataSource : NewsDataSource {

    override fun getSources(): Observable<List<SourcesResponse>> {
        return Observable.empty()
    }

    override fun getArticles(): Observable<List<ArticlesResponse>> {
        return Observable.empty()
    }
}