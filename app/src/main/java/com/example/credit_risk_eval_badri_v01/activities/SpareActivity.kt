package com.example.credit_risk_eval_badri_v01.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.credit_risk_eval_badri_v01.databinding.ActivitySpareBinding

class SpareActivity : AppCompatActivity() {

    private lateinit var binding:ActivitySpareBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySpareBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // In your second activity
        val receivedData = intent.getStringExtra("key")
//        binding.tvtext.text = receivedData

        if(receivedData=="1"){
            startActivity(Intent(applicationContext, ClientDocumentsScreenActivity::class.java))
            finish()
        }
        else if(receivedData=="0"){
            startActivity(Intent(applicationContext, PersonalityAssessmentActivity::class.java))
            finish()
        }
        else{

        }



    }
}