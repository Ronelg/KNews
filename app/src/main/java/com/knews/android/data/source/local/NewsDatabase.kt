package com.knews.android.data.source.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.knews.android.data.Article
import com.knews.android.data.Source
import com.knews.android.model.dao.ArticleDao
import com.knews.android.model.dao.SourceDao


/**
 * Created by ronelg on 10/2/17.
 */

@Database(entities = arrayOf(
        Article::class,
        Source::class
), version = 1)
abstract class NewsDatabase : RoomDatabase() {
    abstract fun articlesDao(): ArticleDao
    abstract fun sourcesDao(): SourceDao
}