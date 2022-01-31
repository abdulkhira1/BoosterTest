package com.booster.test.extension

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity

fun Context.navigateTo(to: AppCompatActivity, bundle: Bundle? = null) {
    val intent = Intent(this, to::class.java)
    bundle?.let {
        intent.putExtras(bundle)
    }
    startActivity(intent)
}



fun ActionBar.showBackOption() {
    this.setDisplayShowHomeEnabled(true)
    this.setDisplayHomeAsUpEnabled(true)
}

fun AppCompatActivity.onHomePress() {
    this.onBackPressed()
}