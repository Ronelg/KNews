package com.knews.android

interface BaseView<P: BasePresenter> {

    var presenter: P?

}