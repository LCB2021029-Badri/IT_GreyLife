package com.example.credit_risk_eval_badri_v01.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.credit_risk_eval_badri_v01.MainActivity
import com.example.credit_risk_eval_badri_v01.R
import com.example.credit_risk_eval_badri_v01.databinding.ActivitySignupBinding
import com.example.credit_risk_eval_badri_v01.models.UserModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

class SignupActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignupBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var database: FirebaseDatabase
    private lateinit var lender:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lender = "0"
        binding.rbGroup.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.rbLender -> {
                    lender="1"
                }
            }
        }

        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()
        binding.btnSignup.setOnClickListener {
            btnSignupCLick()
        }

        binding.tvLogin.setOnClickListener {
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }

    }

    private fun btnSignupCLick(){
        val email = binding.etEmail.text.toString()
        val confirmEmail = binding.etConfirmEmail.text.toString()
        val pass = binding.etPassword.text.toString()
        val confirmPass = binding.etConfirmPassword.text.toString()
        if(email.isNotEmpty() && confirmEmail.isNotEmpty() && pass.isNotEmpty() && confirmPass.isNotEmpty()){
            if(email == confirmEmail && pass == confirmPass){
                auth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener {
                    if(it.isSuccessful){

                        uploadDataToDatabase()

                    }else{
                        Toast.makeText(this,it.exception.toString(),Toast.LENGTH_SHORT).show()
                    }
                }
            }else{
                Toast.makeText(this,"password or email is not matching !",Toast.LENGTH_SHORT).show()
            }
        }else{
            Toast.makeText(this,"empty fields not allowed !",Toast.LENGTH_SHORT).show()
        }
    }

    private fun uploadDataToDatabase(){
        val user = UserModel(auth.uid.toString(),
            binding.etName.text.toString(),
            binding.etEmail.text.toString(),
            lender)

        database.reference.child("users")
            .child(auth.uid.toString())
            .setValue(user)
            .addOnSuccessListener {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
            .addOnFailureListener {
//              createSnackBar(binding.root,"failed to upload data to Realtime DB","Try Again")
            }
    }

}