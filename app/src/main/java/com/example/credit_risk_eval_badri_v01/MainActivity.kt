package com.example.credit_risk_eval_badri_v01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.credit_risk_eval_badri_v01.activities.HomeScreenActivity
import com.example.credit_risk_eval_badri_v01.activities.LoginActivity
import com.example.credit_risk_eval_badri_v01.activities.PersonalityAssessmentActivity
import com.example.credit_risk_eval_badri_v01.activities.StatusScreenActivity
import com.example.credit_risk_eval_badri_v01.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        auth = Firebase.auth
        val currentUser = auth.currentUser
        if (currentUser == null) {
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }


        binding.btnAssessmentActivity.setOnClickListener {
            startActivity(Intent(applicationContext, PersonalityAssessmentActivity::class.java))
        }
        binding.btnHomeActivity.setOnClickListener {
            startActivity(Intent(applicationContext, HomeScreenActivity::class.java))
        }
        binding.btnLogout.setOnClickListener {
            Toast.makeText(applicationContext,"Logged out", Toast.LENGTH_SHORT).show()
            auth.signOut()
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }


    }
}