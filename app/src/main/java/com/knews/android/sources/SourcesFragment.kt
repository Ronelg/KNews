package com.knews.android.sources

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.knews.android.R
import com.knews.android.data.Source

/**
 * Created by asafvaron on 02/10/2017.
 */
class SourcesFragment: Fragment(), SourcesContract.View {

    private val TAG: String = "SourcesFragment"

    private lateinit var sourcesAdapter: SourcesAdapter

    override var presenter: SourcesContract.Presenter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.sources_fragment, container, false)

        with(root) {
            val recyclerSources = findViewById<RecyclerView>(R.id.sources_list)
            setupRecyclerView(recyclerSources)
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
        sourcesAdapter = SourcesAdapter()
        recyclerNews.layoutManager = LinearLayoutManager(context,
                LinearLayoutManager.VERTICAL, false)
        recyclerNews.adapter = sourcesAdapter
    }

    override fun showSources(sources: List<Source>) {
        Log.d(TAG, "showSources, source: $sources")
        sourcesAdapter.setItems(sources)
    }

    companion object {
        fun newInstance(): SourcesFragment {
            return SourcesFragment()
        }
    }
}