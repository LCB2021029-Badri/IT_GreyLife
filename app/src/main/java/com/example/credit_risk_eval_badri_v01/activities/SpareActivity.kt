package com.example.credit_risk_eval_badri_v01.activities

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.credit_risk_eval_badri_v01.R
import com.example.credit_risk_eval_badri_v01.databinding.ActivitySpareBinding

class SpareActivity : AppCompatActivity() {

    private lateinit var binding:ActivitySpareBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySpareBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // In your second activity
        val receivedData = intent.getStringExtra("key")
        binding.tvtext.text = receivedData



    }
}