package com.knews.android;

import com.knews.android.data.source.remote.NewsRemoteDataSource
import com.knews.android.data.source.remote.net.NetworkModule;

import dagger.Component;

@Component(
        modules = arrayOf(NetworkModule::class)
)
interface NewsComponent {
    fun inject(source: NewsRemoteDataSource)
}