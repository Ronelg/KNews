package com.knews.android.model.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.knews.android.data.Article
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Update

/**
 * Created by ronelg on 10/2/17.
 */
@Dao
interface ArticleDao {

    /**
     * Select all articles from the articles table.
     *
     * @return all articles.
     */
    @Query("SELECT * FROM Articles")
    fun getArticles(): List<Article>

    /**
     * Select a article by id.
     */
    @Query("SELECT * FROM Articles WHERE id = :articleId")
    fun getArticleById(articleId: String): Article

    /**
     * Insert a article in the database. If the article already exists, replace it.
     *
     * @param article the article to be inserted.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertArticle(article: Article)

    /**
     * Update a article.
     *
     * @param article task to be updated
     * @return the number of article updated. This should always be 1.
     */
    @Update
    fun updateArticle(article: Article): Int


    /**
     * Delete all articles.
     */
    @Query("DELETE FROM Articles")
    fun deleteArticles()
}