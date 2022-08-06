package com.example.jokenpo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.jokenpo.databinding.ActivityResultBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class ResultActivity : AppCompatActivity() {
    private lateinit var bindingResult: ActivityResultBinding
    private lateinit var drawerResult: DrawerLayout
    private lateinit var navDrawerResult: NavigationView
    private lateinit var bottomNavResult: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindingResult = ActivityResultBinding.inflate(layoutInflater)
        val toolbarResult = bindingResult.toolbarResult

        setContentView(bindingResult.root)
        setSupportActionBar(toolbarResult)

        setupToolbarResult()

        drawerResult = bindingResult.root
        navDrawerResult = bindingResult.navViewResult
        bottomNavResult = bindingResult.bottonNavResult

//        setupDrawerResult()







    }




    override fun onSupportNavigateUp(): Boolean {
        drawerResult.openDrawer(GravityCompat.START)
        return true
    }
//    private fun setupDrawerResult() {
//        navDrawerResult.setNavigationItemSelectedListener { menuItem ->
//            drawerResult.closeDrawers()
//            when(menuItem.itemId){
//                R.id.player -> {
//                    startActivity(Intent(this, MainActivity::class.java))
//                    finish()
//                    true
//                }
//
//                R.id.result -> {
//                    val intentResult = Intent(this, ResultActivity::class.java)
//                    startActivity(intentResult)
//                    finish()
//                    true
//                }
//                else -> false
//            }
//        }
//    }

    private fun setupToolbarResult() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_menu)
    }

//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.main_menu_toolbar, menu)
//        return true
//
//    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        return when(item.itemId){
//            R.id.menuMain -> {
//                val backtoInitial = Intent(this, HomeFragment::class.java)
//                startActivity(backtoInitial)
//                finish()
//                true
//            }
//            else -> false
//        }
//    }
}