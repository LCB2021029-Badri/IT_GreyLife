package com.example.credit_risk_eval_badri_v01.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.credit_risk_eval_badri_v01.R
import com.example.credit_risk_eval_badri_v01.interfaces.MyBlockchainApi
import com.example.credit_risk_eval_badri_v01.models.ChatAdapter
import com.example.credit_risk_eval_badri_v01.models.UserModel
import com.google.firebase.auth.FirebaseAuth
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

class BorrowerLoanDetailsFragment : Fragment() {

    private lateinit var database: FirebaseDatabase

    private lateinit var et1:EditText
    private lateinit var et2:EditText
    private lateinit var et3:EditText
    private lateinit var et4:EditText
    private lateinit var et5:EditText
    private lateinit var et6:EditText
    private lateinit var et7:EditText
    private lateinit var et8:EditText
    private lateinit var et9:EditText
    private lateinit var et10:EditText
    private lateinit var userName:String
    private lateinit var uid:String
    private lateinit var sritScore:String
    private lateinit var loanType:String


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_borrower_loan_details, container, false)

        val btnNext:Button = view.findViewById(R.id.btnSubmit)
        val tvLoanType:TextView = view.findViewById(R.id.tvLoanType)
        et1= view.findViewById(R.id.etNoOfDependents)
        et2 = view.findViewById(R.id.etEducation)
        et3 = view.findViewById(R.id.etIncomeAnnum)
        et4 = view.findViewById(R.id.etLoanAmount)
        et5 = view.findViewById(R.id.etLoanTerm)
        et6 = view.findViewById(R.id.etCIBILScore)
        et7 = view.findViewById(R.id.etResedentialAssetsValie)
        et8 = view.findViewById(R.id.etCommercialAssetsValue)
        et9 = view.findViewById(R.id.etLuxuryAssetsValue)
        et10 = view.findViewById(R.id.etBankAsssetsValue)


        //--------------------
        initializeData()
        //---------------------


        tvLoanType.text = loanType

        btnNext.setOnClickListener {
            if(
                et1.text.isNullOrEmpty()||
                et2.text.isNullOrEmpty()||
                et3.text.isNullOrEmpty()||
                et4.text.isNullOrEmpty()||
                et5.text.isNullOrEmpty()||
                et6.text.isNullOrEmpty()||
                et7.text.isNullOrEmpty()||
                et8.text.isNullOrEmpty()||
                et9.text.isNullOrEmpty()||
                et10.text.isNullOrEmpty()
            ){
                //check empty attributes
                Toast.makeText(requireContext(),"fill all details",Toast.LENGTH_SHORT).show()
            }
            else{
                //send these details to ml model to get output
                //store all data in database which is accessed by lender
                // store important data in blockchain postdata function from ClientStatusUpdateActivity
            }
        }


        return view
    }

    private fun initializeData(){
        loanType = arguments?.getString("loanType")!!
        val sharedPreferences = requireContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        sritScore = sharedPreferences.getString("testScore","")!!
        database = FirebaseDatabase.getInstance()
        uid= FirebaseAuth.getInstance().uid.toString()
        database.reference.child("users")
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    for(snapshot1 in snapshot.children){
                        val user = snapshot1.getValue(UserModel::class.java)
                        if(user!!.uid == uid){
                            userName = user.name!!
                        }
                    }
                }
                override fun onCancelled(error: DatabaseError) {
                }
            })
    }


}