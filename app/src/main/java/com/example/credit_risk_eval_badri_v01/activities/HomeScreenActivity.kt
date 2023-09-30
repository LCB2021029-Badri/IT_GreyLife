package com.example.credit_risk_eval_badri_v01.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.credit_risk_eval_badri_v01.R
import com.example.credit_risk_eval_badri_v01.databinding.ActivityHomeScreenBinding

class HomeScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bottomNavigationView = binding.bottomNavigation

// Set Home selected
        bottomNavigationView.setSelectedItemId(R.id.homeScreen)

// Perform item selected listener
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.statusScreen -> {
                    startActivity(Intent(applicationContext, StatusScreenActivity::class.java))
                    overridePendingTransition(0, 0)
                    true
                }
                R.id.homeScreen -> true
                R.id.supportScreen -> {
                    startActivity(Intent(applicationContext, SupportScreenActivity::class.java))
                    overridePendingTransition(0, 0)
                    true
                }
                else -> false
            }
        }

    }
}