package com.maclaurin.footballclub

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity


class HomeActivity : AppCompatActivity() {

    private val fragmentManager = supportFragmentManager
    private lateinit var bottomNavigation: BottomNavigationView

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_club -> {
                createClubFragment()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_match -> {
                createMatchFragment()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_favorite -> {
                createFavoriteFragment()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        bottomNavigation = findViewById(R.id.bnv_home)

        createClubFragment()

        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    private fun createClubFragment() {
        val transaction = fragmentManager.beginTransaction()
        val fragment = ClubFragment()
        transaction.replace(R.id.fragment_holder, fragment)
        transaction.commit()
    }

    private fun createMatchFragment() {
        val transaction = fragmentManager.beginTransaction()
        val fragment = MatchFragment()
        transaction.replace(R.id.fragment_holder, fragment)
        transaction.commit()
    }

    private fun createFavoriteFragment() {
        val transaction = fragmentManager.beginTransaction()
        val fragment = FavoriteFragment()
        transaction.replace(R.id.fragment_holder, fragment)
        transaction.commit()
    }
}
