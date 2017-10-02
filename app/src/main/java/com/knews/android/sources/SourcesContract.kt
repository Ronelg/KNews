package com.knews.android.sources

import com.knews.android.BasePresenter
import com.knews.android.BaseView
import com.knews.android.data.Source

/**
 * Created by asafvaron on 02/10/2017.
 */
interface SourcesContract {

    interface View: BaseView<Presenter> {
        fun showSources(sources: List<Source>)

    }

    interface Presenter: BasePresenter {
    }
}