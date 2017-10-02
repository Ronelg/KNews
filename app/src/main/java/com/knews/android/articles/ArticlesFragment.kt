package com.knews.android.articles

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.knews.android.R
import com.knews.android.data.Article

/**
 * Created by asafvaron on 02/10/2017.
 */
class ArticlesFragment : Fragment(), ArticlesContract.View {

    override var presenter: ArticlesContract.Presenter? = null

    companion object {
        fun newInstance(): ArticlesFragment {
            return ArticlesFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater!!.inflate(R.layout.articles_fragment, container, false)

        with(root) {
            val recyclerNews = findViewById<RecyclerView>(R.id.recycler_news)
            setupRecyclerView(recyclerNews)
        }

        return root
    }

    private fun setupRecyclerView(recyclerNews: RecyclerView) {

    }

    override fun showArticles(articles: List<Article>) {

    }
}