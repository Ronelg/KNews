package com.knews.android.di.modules

import android.arch.persistence.room.Room
import com.knews.android.NewsApplication
import com.knews.android.data.source.local.NewsDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by ronelg on 10/2/17.
 */
@Module
class ApplicationModule(val application: NewsApplication) {

    @Provides
    @Singleton
    fun provideApplication() = application

    @Provides
    @Singleton
    fun provideNewsDatabase(): NewsDatabase = Room.databaseBuilder(application, NewsDatabase::class.java,
            "newsdb").build()
}