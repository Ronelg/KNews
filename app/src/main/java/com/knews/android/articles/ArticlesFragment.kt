package com.knews.android.articles

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.knews.android.R

/**
 * Created by asafvaron on 02/10/2017.
 */
class ArticlesFragment : Fragment(), ArticlesContract.View {

    companion object {
        fun newInstance(): ArticlesFragment {
            return ArticlesFragment()
        }
    }

    override var presenter: ArticlesContract.Presenter?
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
        set(value) {}

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


    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}