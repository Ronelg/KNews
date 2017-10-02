package com.knews.android.articles

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.knews.android.MainActivity
import com.knews.android.R
import com.knews.android.data.Article

/**
 * Created by asafvaron on 02/10/2017.
 */
class ArticlesFragment : Fragment(), ArticlesContract.View, ArticlesAdapter.ArticleClickListener {

    private val TAG: String = "ArticlesFragment"

    override var presenter: ArticlesContract.Presenter? = null

    private lateinit var articlesAdapter: ArticlesAdapter
    private var mSourceId: String? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.articles_fragment, container, false)

        mSourceId = arguments.getString(KEY_SOURCE_ID)

        with(root) {
            val recyclerNews = findViewById<RecyclerView>(R.id.recycler_news)
            setupRecyclerView(recyclerNews)
            Log.d(TAG, "init complete")
        }

        return root
    }

    override fun onResume() {
        super.onResume()
        presenter?.subscribe()
    }

    override fun onPause() {
        super.onPause()
        presenter?.unsubscribe()
    }

    private fun setupRecyclerView(recyclerNews: RecyclerView) {
        articlesAdapter = ArticlesAdapter(this)
        recyclerNews.layoutManager = LinearLayoutManager(context,
                LinearLayoutManager.VERTICAL, false)
        recyclerNews.adapter = articlesAdapter
    }

    override fun showArticles(articles: List<Article>) {
        Log.d(TAG, "showArticles, articles: $articles")
        articlesAdapter.setItems(articles)
    }

    override fun onArticleClicked(url: String?) {
        Log.d("onArticleClicked", "url: $url")
        if (activity is MainActivity) {
            (activity as MainActivity).loadWebArticle(url)
        }
    }

    companion object {
        val KEY_SOURCE_ID = "key:source_id"
        fun newInstance(id: String): ArticlesFragment {
            val fragment = ArticlesFragment()
            val args = Bundle()
            args.putString(KEY_SOURCE_ID, id)
            fragment.arguments = args
            return fragment

        }
    }
}