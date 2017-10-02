package com.knews.android.articles

import com.knews.android.BasePresenter
import com.knews.android.BaseView
import com.knews.android.data.Article

/**
 * Created by asafvaron on 02/10/2017.
 */
interface ArticlesContract {

    interface View : BaseView<Presenter> {
        fun showArticles(articles: List<Article>)
    }

    interface Presenter : BasePresenter {

    }
}