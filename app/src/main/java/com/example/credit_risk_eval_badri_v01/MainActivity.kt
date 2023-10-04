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
import com.example.credit_risk_eval_badri_v01.models.UserModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var database: FirebaseDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        auth = Firebase.auth
        database = FirebaseDatabase.getInstance()


        checkLogin()
        showLendingStatus()

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

    private fun showLendingStatus(){
        database.reference.child("users")
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    for(snapshot1 in snapshot.children){
                        val user = snapshot1.getValue(UserModel::class.java)
                        if(user!!.uid == FirebaseAuth.getInstance().uid){
                            binding.tvLending.text = user!!.lender
                        }
                    }

                }
                override fun onCancelled(error: DatabaseError) {
                }
            })
    }

    private fun checkLogin(){
        val currentUser = auth.currentUser
        if (currentUser == null) {
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }
    }

}