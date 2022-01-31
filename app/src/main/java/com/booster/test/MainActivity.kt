package com.booster.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.booster.test.databinding.ActivityMainBinding
import com.booster.test.utils.Constants
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_top_toolbar.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var binding: ActivityMainBinding
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init() {

        navController = findNavController(R.id.nav_host_fragment)
        drawerNavigation.setNavigationItemSelectedListener(this)

        btnMenu.setOnClickListener {
            openDrawer()
        }

    }


    fun openDrawer() {
        drawerLayout.openDrawer(drawerNavigation)
    }

    fun closeDrawer() {
        drawerLayout.closeDrawer(drawerNavigation)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        closeDrawer()
        when (item.itemId) {
            R.id.btnHome -> {
                Constants.navigateFragment(navController, R.id.navigation_home)
            }
            R.id.btnCapitalFund -> {
                val bundle = Bundle()
                bundle.putSerializable(Constants.INVESTOR_TYPE, getString(R.string.capital_guaranteed_fund))
                Constants.navigateFragment(navController, R.id.navigation_investor_type, bundle)
            }
            R.id.btnDefaultFund -> {
                val bundle = Bundle()
                bundle.putSerializable(Constants.INVESTOR_TYPE, getString(R.string.default_saver_fund))
                Constants.navigateFragment(navController, R.id.navigation_investor_type, bundle)
            }
            R.id.btnModerateFund -> {
                val bundle = Bundle()
                bundle.putSerializable(Constants.INVESTOR_TYPE, getString(R.string.moderate_fund))
                Constants.navigateFragment(navController, R.id.navigation_investor_type, bundle)
            }
            R.id.btnBalancedFund -> {
                val bundle = Bundle()
                bundle.putSerializable(Constants.INVESTOR_TYPE, getString(R.string.balanced_fund))
                Constants.navigateFragment(navController, R.id.navigation_investor_type, bundle)
            }
            R.id.btnBalancedGrowthFund -> {
                val bundle = Bundle()
                bundle.putSerializable(Constants.INVESTOR_TYPE, getString(R.string.balanced_growth_fund))
                Constants.navigateFragment(navController, R.id.navigation_investor_type, bundle)
            }
            R.id.btnHighGrowthFund -> {
                val bundle = Bundle()
                bundle.putSerializable(Constants.INVESTOR_TYPE, getString(R.string.high_growth_fund))
                Constants.navigateFragment(navController, R.id.navigation_investor_type, bundle)
            }
        }
        return true
    }


}