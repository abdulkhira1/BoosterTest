package com.booster.test.ui.activity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.booster.test.MainActivity
import com.booster.test.R
import com.booster.test.extension.navigateTo
import kotlinx.android.synthetic.main.activity_splash.*
import kotlinx.android.synthetic.main.layout_top_toolbar.*

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        btnMenu.visibility = View.GONE
        btnWelcome.setOnClickListener { navigateTo(MainActivity()) }

    }
}