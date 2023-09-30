package com.example.credit_risk_eval_badri_v01.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.credit_risk_eval_badri_v01.R
import com.example.credit_risk_eval_badri_v01.databinding.ActivityStatusScreenBinding

class StatusScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStatusScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStatusScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //
        val bottomNavigationView = binding.bottomNavigation

// Set Dashboard selected
        bottomNavigationView.setSelectedItemId(R.id.statusScreen)

// Perform item selected listener
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.homeScreen -> {
                    startActivity(Intent(applicationContext, HomeScreenActivity::class.java))
                    overridePendingTransition(0, 0)
                    true
                }
                R.id.statusScreen -> true
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