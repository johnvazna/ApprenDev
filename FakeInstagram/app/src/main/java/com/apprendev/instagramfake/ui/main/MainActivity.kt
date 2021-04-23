package com.apprendev.instagramfake.ui.main

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.apprendev.instagramfake.R
import com.apprendev.instagramfake.ui.account.AccountFragment
import com.apprendev.instagramfake.ui.explorer.ExplorerFragment
import com.apprendev.instagramfake.ui.home.HomeFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navBottom.setOnNavigationItemSelectedListener(this)
        replaceFragment(HomeFragment())
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.nav_home -> replaceFragment(HomeFragment())
            R.id.nav_search -> replaceFragment(ExplorerFragment())
            R.id.nav_account -> replaceFragment(AccountFragment())
        }
        return true
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            FragmentTransaction.TRANSIT_FRAGMENT_OPEN
            replace(R.id.container, fragment)
            addToBackStack(null)
            commit()
        }
    }

}