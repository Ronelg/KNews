package com.knews.android.sources

import android.util.Log
import com.knews.android.data.source.NewsRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by asafvaron on 02/10/2017.
 */
class SourcesPresenter(private val newsRepository: NewsRepository,
                       private val sourcesView: SourcesContract.View)
    : SourcesContract.Presenter {

    init {
        sourcesView.presenter = this
    }

    private val disposables: CompositeDisposable = CompositeDisposable()

    override fun subscribe() {
        val disposable = newsRepository.getSources()
                .observeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe({ res ->
                    sourcesView.showSources(res.flatMap { it.sources })
                }, { t ->
                    Log.e("getSources", "ERR: $t")
                })

        disposables.add(disposable)
    }

    override fun unsubscribe() {
        disposables.clear()
    }
}