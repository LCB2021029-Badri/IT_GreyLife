package com.example.credit_risk_eval_badri_v01.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.credit_risk_eval_badri_v01.R
import com.example.credit_risk_eval_badri_v01.databinding.ActivityStatusScreenBinding
import com.example.credit_risk_eval_badri_v01.databinding.ActivitySupportScreenBinding

class SupportScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySupportScreenBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySupportScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        enableBottomNavView()


    }

    private fun enableBottomNavView(){
        val bottomNavigationView = binding.bottomNavigation
        bottomNavigationView.setSelectedItemId(R.id.supportScreen)
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.homeScreen -> {
                    startActivity(Intent(applicationContext, HomeScreenActivity::class.java))
                    finish()
                    overridePendingTransition(0, 0)
                    true
                }
                R.id.supportScreen -> true
                R.id.statusScreen -> {
                    startActivity(Intent(applicationContext, StatusScreenActivity::class.java))
                    finish()
                    overridePendingTransition(0, 0)
                    true
                }
                R.id.notificationsScreen -> {
                    startActivity(Intent(applicationContext, NotificationsScreenActivity::class.java))
                    finish()
                    overridePendingTransition(0, 0)
                    true
                }
                else -> false
            }
        }
    }

}