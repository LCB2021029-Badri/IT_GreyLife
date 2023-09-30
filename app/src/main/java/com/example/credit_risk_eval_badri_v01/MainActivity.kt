package com.example.credit_risk_eval_badri_v01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.credit_risk_eval_badri_v01.activities.HomeScreenActivity
import com.example.credit_risk_eval_badri_v01.activities.PersonalityAssessmentActivity
import com.example.credit_risk_eval_badri_v01.activities.StatusScreenActivity
import com.example.credit_risk_eval_badri_v01.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        startActivity(Intent(applicationContext, HomeScreenActivity::class.java))
        startActivity(Intent(applicationContext, PersonalityAssessmentActivity::class.java))

    }
}