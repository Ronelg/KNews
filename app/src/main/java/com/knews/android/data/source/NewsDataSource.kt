package com.knews.android.data.source

import com.knews.android.model.ArticlesResponse
import com.knews.android.model.SourcesResponse
import io.reactivex.Observable

/**
 * Created by ronelg on 10/2/17.
 */
interface NewsDataSource {

    fun getArticles(): Observable<List<ArticlesResponse>>

    fun getSources(): Observable<List<SourcesResponse>>

}