package com.knews.android.model

import com.knews.android.data.Article

/**
 * Created by ronelg on 10/2/17.
 */
class ArticlesResponse(
        val status: String,
        val source: String,
        val sortBy: String,
        val articles: List<Article>) {

}