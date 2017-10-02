package com.knews.android.di.components

import android.app.Application
import com.knews.android.data.source.remote.NewsRemoteDataSource
import com.knews.android.di.modules.ApplicationModule
import com.knews.android.di.modules.NetworkModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by ronelg on 10/2/17.
 */
@Singleton
@Component(modules = arrayOf(
        ApplicationModule::class,
        NetworkModule::class))
interface ApplicationComponent {
    fun inject(app: Application)
    fun inject(app: NewsRemoteDataSource)
}