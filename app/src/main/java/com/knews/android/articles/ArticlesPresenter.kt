package com.knews.android.articles

import android.util.Log
import com.knews.android.data.source.NewsRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by asafvaron on 02/10/2017.
 */
class ArticlesPresenter(
        private val sourceId: String,
        private val newsRepository: NewsRepository,
        private val articlesView: ArticlesContract.View)
    : ArticlesContract.Presenter {

    init {
        articlesView.presenter = this
    }

    private val disposables: CompositeDisposable = CompositeDisposable()

    override fun subscribe() {
        Log.d("ArticlesPresenter", "subscribe")
        val disposable = newsRepository.getArticles(sourceId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ res ->
                    articlesView.showArticles(res)
                }, { t ->
                    Log.e("ArticlesPresenter", "getArticles error: $t")
                })

        disposables.add(disposable)
    }

    override fun unsubscribe() {
        disposables.clear()
    }
}