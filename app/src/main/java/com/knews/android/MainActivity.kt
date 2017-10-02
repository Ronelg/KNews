package com.knews.android

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import com.knews.android.articles.ArticlesFragment
import com.knews.android.articles.ArticlesPresenter
import com.knews.android.data.source.NewsRepository
import com.knews.android.data.source.local.NewsLocalDataSource
import com.knews.android.data.source.remote.NewsRemoteDataSource
import com.knews.android.sources.SourcesFragment
import com.knews.android.sources.SourcesPresenter

class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var articlePresenter: ArticlesPresenter
    private lateinit var sourcesPresenter: SourcesPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        // Set up the toolbar.
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.let {
            it.setHomeAsUpIndicator(R.drawable.ic_action_back)
            it.setDisplayHomeAsUpEnabled(true)
        }

        // Set up the navigation drawer.
        drawerLayout = (findViewById<DrawerLayout>(R.id.drawer_layout)).apply {
            setStatusBarBackground(R.color.colorPrimaryDark)
        }

        val navigationView = findViewById<NavigationView>(R.id.nav_view)
        setupDrawerContent(navigationView)

        // init Sources fragment
        val sourcesFragment = SourcesFragment.newInstance()
        supportFragmentManager.beginTransaction()
                .replace(R.id.frags_container, sourcesFragment, sourcesFragment.tag)
                .commit()

        sourcesPresenter = SourcesPresenter(NewsRepository.getInstance(
                NewsRemoteDataSource.getInstance(),
                NewsLocalDataSource.getInstance(applicationContext)),
                sourcesFragment)

        // init Articles fragment
        val articlesFragment = ArticlesFragment.newInstance()
        articlePresenter = ArticlesPresenter(NewsRepository.getInstance(
                NewsRemoteDataSource.getInstance(),
                NewsLocalDataSource.getInstance(applicationContext)),
                articlesFragment)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            // Open the navigation drawer when the home icon is selected from the toolbar.
            drawerLayout.openDrawer(GravityCompat.START)
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setupDrawerContent(navigationView: NavigationView) {
        navigationView.setNavigationItemSelectedListener { menuItem ->
            //                TODO("Add sources to drawer clicks")
//            if (menuItem.itemId == R.id.callllogs_navigation_menu_item) {
//            } else if (menuItem.itemId == R.id.bootsrap_navigation_menu_item) {
//            }
            // Close the navigation drawer when an item is selected.
            menuItem.isChecked = true
            drawerLayout.closeDrawers()
            true
        }
    }
}
