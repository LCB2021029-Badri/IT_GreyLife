package com.example.credit_risk_eval_badri_v01.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.credit_risk_eval_badri_v01.R
import com.example.credit_risk_eval_badri_v01.databinding.ActivityDocsDetailsBinding
import com.example.credit_risk_eval_badri_v01.models.LoanDataModel
import com.example.credit_risk_eval_badri_v01.models.UserModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.ktx.Firebase

class DocsDetailsActivity : AppCompatActivity() {

    private lateinit var binding:ActivityDocsDetailsBinding
    private lateinit var uid: String
    private lateinit var database: FirebaseDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDocsDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        uid = intent.getStringExtra("uid")!!
        database = FirebaseDatabase.getInstance()

        database.reference.child("loans")
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    for(snapshot1 in snapshot.children){
                        val data = snapshot1.getValue(LoanDataModel::class.java)
                        if(data!!.uid == uid){


                            binding.tv1.text = data.name
                            binding.tv2.text = data.uid
                            binding.tv3.text = data.loanType
                            binding.tv4.text = data.noOfDependents
                            binding.tv5.text = data.education
                            binding.tv6.text = data.sritscore
                            binding.tv7.text = data.etIncomeeAnnum
                            binding.tv8.text = data.etLoanAmount
                            binding.tv9.text = data.etLoanTerm
                            binding.tv10.text = data.etCIBILScore
                            binding.tv11.text = data.etResedentialAssetsValie
                            binding.tv12.text = data.etCommercialAssetsValue
                            binding.tv13.text = data.etLuxuryAssetsValue
                            binding.tv14.text = data.etBankAsssetsValue
                            binding.tv15.text = data.mlOutput
                            binding.tv16.text = data.email



                            break
                        }
                    }

                }
                override fun onCancelled(error: DatabaseError) {
//                    dialog.dismiss()
                }
            })


    }




}