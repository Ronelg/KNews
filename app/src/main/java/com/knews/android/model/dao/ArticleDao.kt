package com.knews.android.model.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import com.knews.android.data.Article

/**
 * Created by ronelg on 10/2/17.
 */
@Dao
class ArticleDao {

    @Query("SELECT * FROM Atricles")
    fun getAr(): List<Article>
}