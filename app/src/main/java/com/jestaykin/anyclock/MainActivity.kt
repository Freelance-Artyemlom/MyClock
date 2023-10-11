package com.jestaykin.anyclock

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.jestaykin.anyclock.About.AboutDialog
import com.jestaykin.anyclock.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        window.statusBarColor = getColor(R.color.centerColor)

        binding.toolbar.setOnMenuItemClickListener(toolBarListener)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment
        val navController = navHostFragment.navController
        findViewById<BottomNavigationView>(R.id.btm_nav).setupWithNavController(navController)
    }

    val toolBarListener = Toolbar.OnMenuItemClickListener {
        when (it.itemId) {
            R.id.about -> {
                AboutDialog().show(supportFragmentManager, "about_dialog")
            }
        }
        true
    }
}
