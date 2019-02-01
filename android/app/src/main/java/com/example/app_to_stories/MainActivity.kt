package com.example.app_to_stories

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        load()
    }

    private fun load() {
        supportFragmentManager
            .beginTransaction()
            .add(R.id.container, ShareFragment())
            .commitAllowingStateLoss()
    }
}
