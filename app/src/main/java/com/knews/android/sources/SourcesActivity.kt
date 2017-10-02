package com.knews.android.sources

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import com.knews.android.R
import com.knews.android.data.source.NewsRepository
import com.knews.android.data.source.local.NewsLocalDataSource
import com.knews.android.data.source.remote.NewsRemoteDataSource

class SourcesActivity : AppCompatActivity() {

    private val TAG: String = "SourcesActivity"

    private lateinit var drawerLayout: DrawerLayout
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

        // show only when inside an article
        supportActionBar?.let {
            it.setHomeAsUpIndicator(R.drawable.ic_menu)
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
            // TODO add sources items here
            // Close the navigation drawer when an item is selected.
            menuItem.isChecked = true
            drawerLayout.closeDrawers()
            true
        }
    }
}
