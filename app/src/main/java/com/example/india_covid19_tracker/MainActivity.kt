package com.example.india_covid19_tracker

import android.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.india_covid19_tracker.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        val navHostController=this.findNavController(R.id.MyNavHost)
        NavigationUI.setupActionBarWithNavController(this,navHostController)
    }
    override fun onSupportNavigateUp(): Boolean {
        val navHostController=this.findNavController(R.id.MyNavHost)
        return navHostController.navigateUp()
    }
}