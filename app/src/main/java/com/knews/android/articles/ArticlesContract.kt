package com.knews.android.articles

import com.knews.android.BasePresenter
import com.knews.android.BaseView

/**
 * Created by asafvaron on 02/10/2017.
 */
interface ArticlesContract {

    interface View : BaseView<Presenter> {

    }

    interface Presenter : BasePresenter {

    }
}