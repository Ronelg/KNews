package com.knews.android.articles

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.MenuItem
import com.knews.android.R
import com.knews.android.WebArticleFragment
import com.knews.android.data.source.NewsRepository
import com.knews.android.data.source.local.NewsLocalDataSource
import com.knews.android.data.source.remote.NewsRemoteDataSource


class ArticlesActivity : AppCompatActivity() {

    private val TAG: String = "ArticlesActivity"

    private lateinit var articlePresenter: ArticlesPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.articles_activity)
        init()
    }

    private fun init() {
        Log.d(TAG, "init")
        // Set up the toolbar.
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        // show only when inside an article
        supportActionBar?.let {
            it.setHomeAsUpIndicator(R.drawable.ic_action_back)
            it.setDisplayHomeAsUpEnabled(true)
        }

        loadArticles(intent.getStringExtra("id"))
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    fun loadWebArticle(url: String?) {
        Log.d(TAG, "loadWebArticle, url: $url")
        val webArticleFragment = WebArticleFragment.newInstance(url)
        supportFragmentManager.beginTransaction()
                .replace(R.id.frags_container, webArticleFragment, webArticleFragment.tag)
                .addToBackStack(null)
                .commit()
    }

    private fun loadArticles(id: String) {
        Log.d(TAG, "loadArticles, url: $id")
        val articlesFragment = ArticlesFragment.newInstance(id)
        supportFragmentManager.beginTransaction()
                .replace(R.id.frags_container, articlesFragment, articlesFragment.tag)
                .addToBackStack(null)
                .commit()

        // init Articles presenter
        articlePresenter = ArticlesPresenter(NewsRepository.getInstance(
                NewsRemoteDataSource.getInstance(),
                NewsLocalDataSource.getInstance(applicationContext)),
                articlesFragment)
    }
}
