package com.ifs21010.linkedinbaru

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.Toolbar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.navigation.NavigationView

class HalamanAwal : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var drawerLayout: DrawerLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_halaman_awal)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        drawerLayout = findViewById(R.id.myDrawerLayout)
        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.gas)
        setSupportActionBar(toolbar)

        val navigationView = findViewById<NavigationView>(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)

        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_nav, R.string.close_nav)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        if (savedInstanceState == null) {
            replaceFragment(HomeFragment())
            navigationView.setCheckedItem(R.id.home)
        }

        val bottomHome : ImageView = findViewById(R.id.bottom_home)
        val bottomNetwork : ImageView = findViewById(R.id.bottom_network)
        val bottomPost : ImageView = findViewById(R.id.bottom_post)
        val bottomNotification : ImageView = findViewById(R.id.bottom_notification)
        val bottomJobs : ImageView = findViewById(R.id.bottom_jobs)

        bottomHome.setOnClickListener {
            replaceFragment(HomeFragment())
        }

        bottomNetwork.setOnClickListener {
            replaceFragment(NetworkFragment())
        }

        bottomPost.setOnClickListener {
            replaceFragment(PostFragment())
        }

        bottomNotification.setOnClickListener {
            replaceFragment(NotificationsFragment())
        }

        bottomJobs.setOnClickListener {
            replaceFragment(JobsFragment())
        }

    }

    private fun replaceFragment (fragment: Fragment) {
        val transaction : FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainer, fragment)
        transaction.commit()
    }

    @SuppressLint("MissingSuperCall")
    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        }

        else {
            onBackPressedDispatcher.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        when (p0.itemId) {
            R.id.home -> replaceFragment(HomeFragment())
            R.id.grup -> replaceFragment(GrupFragment())
            R.id.events -> replaceFragment(EventFragment())
        }

        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}