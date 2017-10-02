package com.knews.android.data.source

import com.knews.android.data.News
import io.reactivex.Observable

/**
 * Created by ronelg on 10/2/17.
 */
interface NewsDataSource {

    fun getNews(): Observable<List<News>>

}