package com.knews.android

import android.app.Application
import com.knews.android.di.components.ApplicationComponent
import com.knews.android.di.components.DaggerApplicationComponent

/**
 * Created by ronelg on 10/2/17.
 */
class NewsApplication: Application() {

    companion object {
        lateinit var appComponent: ApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerApplicationComponent.create()
        appComponent.inject(this)
    }

}