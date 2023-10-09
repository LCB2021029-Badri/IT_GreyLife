package com.example.credit_risk_eval_badri_v01.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.example.credit_risk_eval_badri_v01.R
import com.example.credit_risk_eval_badri_v01.databinding.ActivityClientUpdateStatusBinding
import com.example.credit_risk_eval_badri_v01.interfaces.MyBlockchainApi
import com.example.credit_risk_eval_badri_v01.models.LoanDataModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.Credentials
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ClientUpdateStatusActivity : AppCompatActivity() {

    private lateinit var binding:ActivityClientUpdateStatusBinding
    private lateinit var myApi: MyBlockchainApi
    private lateinit var database: FirebaseDatabase


    private lateinit var name:String
    private lateinit var uid:String
    private lateinit var email:String
    private lateinit var loanType:String
    private lateinit var noOfDependents:String
    private lateinit var education:String
    private lateinit var sritscore:String
    private lateinit var etIncomeeAnnum:String
    private lateinit var etLoanAmount:String
    private lateinit var etLoanTerm:String
    private lateinit var etCIBILScore:String
    private lateinit var etResedentialAssetsValie:String
    private lateinit var etCommercialAssetsValue:String
    private lateinit var etLuxuryAssetsValue:String
    private lateinit var etBankAsssetsValue:String
    private lateinit var mlOutput:String



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityClientUpdateStatusBinding.inflate(layoutInflater)
        setContentView(binding.root)

        displayCurrentResultFromDatabase()

        binding.btnUpdate.setOnClickListener {
            updateLLoanDataInDatabase()
//            updateDataInBlockChain()
        }

    }

    private fun displayCurrentResultFromDatabase(){
        database = FirebaseDatabase.getInstance()
        uid = intent.getStringExtra("uid")!!
        database.reference.child("loans")
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    for(snapshot1 in snapshot.children){
                        val data = snapshot1.getValue(LoanDataModel::class.java)
                        if(data!!.uid == uid){
                            binding.tvCurrentResult.text = data.mlOutput
                            name = data.name!!
                            email = data.email!!
                            loanType = data.loanType!!
                            noOfDependents = data.noOfDependents!!
                            education = data.education!!
                            sritscore = data.sritscore!!
                            etIncomeeAnnum = data.etIncomeeAnnum!!
                            etCIBILScore = data.etCIBILScore!!
                            etBankAsssetsValue = data.etBankAsssetsValue!!
                            etLoanTerm = data.etLoanTerm!!
                            etResedentialAssetsValie = data.etResedentialAssetsValie!!
                            etLuxuryAssetsValue = data.etLuxuryAssetsValue!!
                            etLoanAmount = data.etLoanAmount!!
                            etCommercialAssetsValue = data.etCommercialAssetsValue!!
                            mlOutput = data.mlOutput!!

                            break
                        }
                    }
                }
                override fun onCancelled(error: DatabaseError) {
//                    dialog.dismiss()
                }
            })
    }

    private fun updateLLoanDataInDatabase(){
        if(binding.etUpdateResult.text.isNullOrEmpty()){
            //do nothing
        }
        else{

            var loanData = LoanDataModel(
                name,
                uid,
                email,
                loanType,
                noOfDependents,
                education,
                sritscore,
                etIncomeeAnnum,
                etLoanAmount,
                etLoanTerm,
                etCIBILScore,
                etResedentialAssetsValie,
                etCommercialAssetsValue,
                etLuxuryAssetsValue,
                etBankAsssetsValue,
                binding.etUpdateResult.text.toString()
            )

            database.reference.child("loans")
                .child(uid)
                .setValue(loanData)
                .addOnSuccessListener {
//                                startActivity(Intent(this@SignupActivity, MainActivity::class.java))
//                                finish()
                }
                .addOnFailureListener {
//                createSnackBar(binding.root,"failed to upload data to Realtime DB","Try Again")
                }

        }

    }

    private fun updateDataInBlockChain(){

    }


}