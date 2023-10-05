package com.example.credit_risk_eval_badri_v01.activities

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.credit_risk_eval_badri_v01.MainActivity
import com.example.credit_risk_eval_badri_v01.R
import com.example.credit_risk_eval_badri_v01.databinding.ActivitySignupBinding
import com.example.credit_risk_eval_badri_v01.models.LenderLinkModel
import com.example.credit_risk_eval_badri_v01.models.UserModel
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.ktx.Firebase
import java.lang.Integer.MAX_VALUE

class SignupActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignupBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var database: FirebaseDatabase
    private lateinit var dialog: AlertDialog
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
                        createSnackBar(binding.root, "Error " + it.exception.toString(),"Try Again")
                    }
                }
            }else{
                createSnackBar(binding.root, "password or email is not matching !","Try Again")
            }
        }else{
            createSnackBar(binding.root, "empty fields not allowed !","Try Again")
        }
    }

//    private fun uploadDataToDatabase(){
//        dialogBox("Uploading Data to FB Realtime DB","Please Wait ...")
//
//        var user = UserModel(auth.uid.toString(),
//            binding.etName.text.toString(),
//            binding.etEmail.text.toString(),
//            lender,
//            0,
//            "")
//
//        database.reference.child("users")
//            .child(auth.uid.toString())
//            .setValue(user)
//            .addOnSuccessListener {
//                dialog.dismiss()
//                startActivity(Intent(this, MainActivity::class.java))
//                finish()
//            }
//            .addOnFailureListener {
//                dialog.dismiss()
//                createSnackBar(binding.root,"failed to upload data to Realtime DB","Try Again")
//            }
//    }

    private fun createSnackBar(view: View, text: String, actionText:String){
        Snackbar.make(view,text, Snackbar.LENGTH_INDEFINITE)
            .setAnimationMode(BaseTransientBottomBar.ANIMATION_MODE_SLIDE)
            .setBackgroundTint(Color.parseColor("#FF9494"))
            .setTextColor(Color.parseColor("#EE4B28"))
            .setActionTextColor(Color.parseColor("#000000"))
            .setAction(actionText){
//                Toast.makeText(this,"snackbar button pressed",Toast.LENGTH_SHORT).show()
            }
            .show()
    }

    private fun dialogBox(title:String,message:String){
        val builder = AlertDialog.Builder(this)
        builder.setMessage(message)
        builder.setTitle(title)
        builder.setCancelable(false)
        dialog = builder.create()
        dialog.show()
    }

//    private fun assignLeastLinkedLender(){
//        var count:Int = 1000
//        var LENDER_UID:String = ""
//        database.reference.child("users")
//            .addValueEventListener(object : ValueEventListener {
//                override fun onDataChange(snapshot: DataSnapshot) {
//                    for(snapshot1 in snapshot.children){
//                        val user = snapshot1.getValue(UserModel::class.java)
//                        if(user!!.uid != FirebaseAuth.getInstance().uid){
//                            if(user.lender=="1" && user.links!! <count){
//                                count = user.links
//                                LENDER_UID = user.uid!!
//                            }
//                        }
//                    }
//                }
//                override fun onCancelled(error: DatabaseError) {
//                    dialog.dismiss()
//                }
//            })
//    }



    private fun uploadDataToDatabase(){
        var user = UserModel(auth.uid.toString(),
            binding.etName.text.toString(),
            binding.etEmail.text.toString(),
            lender,
            0,
            "")

        if(lender=="0"){
            //finding minimum link lender
            var count:Int = 1000
            var lenderUid:String = ""
            database.reference.child("users")
                .addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        for(snapshot1 in snapshot.children){
                            val user = snapshot1.getValue(UserModel::class.java)
                            if(user!!.uid != FirebaseAuth.getInstance().uid){
                                if(user.lender=="1" && user.links!! <count){
                                    count = user.links
                                    lenderUid = user.uid!!
                                }
                            }
                        }


                        //
//                        database.reference.child("users")
//                            .addValueEventListener(object : ValueEventListener {
//                                var updatedInfo = UserModel()
//                                override fun onDataChange(snapshot: DataSnapshot) {
//                                    for(snapshot1 in snapshot.children){
//                                        val userx = snapshot1.getValue(UserModel::class.java)
//                                        if(userx!!.uid == lenderUid){
//                                            updatedInfo = UserModel(
//                                                userx!!.uid,
//                                                userx!!.name,
//                                                userx!!.email,
//                                                userx!!.lender,
//                                                userx!!.links!! + 1,
//                                                userx!!.partner)
////                                            val dbRef = FirebaseDatabase.getInstance().getReference("users").child(lenderUid)
////                                            dbRef.setValue(updatedInfo)
//                                            break
//                                        }
//                                    }
//
//                                    val dbRef = FirebaseDatabase.getInstance().getReference("users").child(lenderUid)
//                                    dbRef.setValue(updatedInfo)
//
//                                }
//                                override fun onCancelled(error: DatabaseError) {
//
//                                }
//                            })
                        //



                        // saving this borrower to the least linked lender
                        val lenderlink = LenderLinkModel(auth.uid.toString())
                        database.reference.child("everyLenderLinks")
                            .child(lenderUid)
                            .child(auth.uid.toString())
                            .setValue(lenderlink)
                            .addOnSuccessListener {
                            }
                            .addOnFailureListener {
                            }

                        //updated user value is storedd for borrower now
                        user = UserModel(auth.uid.toString(),
                            binding.etName.text.toString(),
                            binding.etEmail.text.toString(),
                            lender,
                            0,
                            lenderUid)
                        database.reference.child("users")
                            .child(auth.uid.toString())
                            .setValue(user)
                            .addOnSuccessListener {
                                startActivity(Intent(this@SignupActivity, MainActivity::class.java))
                                finish()
                            }
                            .addOnFailureListener {
                                createSnackBar(binding.root,"failed to upload data to Realtime DB","Try Again")
                            }
                        //

                    }

                    override fun onCancelled(error: DatabaseError) {
                        dialog.dismiss()
                    }

                })



        }
        //else == 1
        database.reference.child("users")
            .child(auth.uid.toString())
            .setValue(user)
            .addOnSuccessListener {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
            .addOnFailureListener {
                createSnackBar(binding.root,"failed to upload data to Realtime DB","Try Again")
            }


    }


        private fun updateDatabaseValue(){
            val authRef = FirebaseAuth.getInstance()
            val dbRef = FirebaseDatabase.getInstance().getReference("users").child(authRef.uid.toString())
            val updatedInfo = UserModel(auth.uid.toString(),"1","1","1")
            dbRef.setValue(updatedInfo)
        }



}