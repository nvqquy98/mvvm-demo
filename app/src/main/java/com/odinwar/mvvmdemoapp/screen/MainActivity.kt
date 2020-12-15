package com.odinwar.mvvmdemoapp.screen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.odinwar.mvvmdemoapp.R
import com.odinwar.mvvmdemoapp.screen.home.HomeFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container_view, HomeFragment.newInstance()).commit()
    }
}