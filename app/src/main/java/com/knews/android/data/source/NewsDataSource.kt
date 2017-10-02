package com.knews.android.data.source

import com.knews.android.data.Article
import com.knews.android.data.Source
import io.reactivex.Observable

/**
 * Created by ronelg on 10/2/17.
 */
interface NewsDataSource {

    fun getArticles(source: Source? = null): Observable<List<Article>>

    fun getSources(): Observable<List<Source>>

}