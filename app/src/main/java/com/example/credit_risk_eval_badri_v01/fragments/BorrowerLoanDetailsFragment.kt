package com.example.credit_risk_eval_badri_v01.fragments

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
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.Credentials
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class BorrowerLoanDetailsFragment : Fragment() {

    private lateinit var myApi: MyBlockchainApi
    val USERNAME = "u0yxvm2kkq"
    val PASSWORD = "t5OvSDtcASGoP6xRLBAfaYGZQ53XG4IpZHjorph3vtA"
    val BASE_URL =
        "https://u0lj156pi7-u0mlmn54wo-connect.us0-aws.kaleido.io/gateways/greylife/0xe18110e266f642686981ba41179709d241eb04cf/"
    val kldFromValue = "0xdbca2ba3f5843a82ad7c811174d001cb51cc329a"


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_borrower_loan_details, container, false)

        val tvLoanType:TextView = view.findViewById(R.id.tvLoanType)
        val etTesting:EditText = view.findViewById(R.id.etTesting)
        val btnNext:Button = view.findViewById(R.id.btnSubmit)
        val data = arguments?.getString("LoanType")

        tvLoanType.text = data

        btnNext.setOnClickListener {
            if(etTesting.text.isNullOrEmpty()){
                Toast.makeText(requireContext(),"fill all details",Toast.LENGTH_SHORT).show()
            }
            else{
                //store these details in block chain
                uploadDataToBlockChain()
            }
        }


        return view
    }


    private fun uploadDataToBlockChain(){
        eetrofitCreate()
        postData()
    }

    private fun eetrofitCreate() {
        val credentials = Credentials.basic(
            USERNAME,
            PASSWORD
        )
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(
                //-----------------------
                OkHttpClient.Builder()
                    .addInterceptor(HttpLoggingInterceptor().apply {
                        level = HttpLoggingInterceptor.Level.BODY
                    })
                    .addInterceptor { chain ->
                        val newRequest = chain.request().newBuilder()
                            .header("Authorization", credentials)
                            .build()
                        chain.proceed(newRequest)
                    }
                    .build()
                //------------------------
            )
            .build()

        myApi = retrofit.create(MyBlockchainApi::class.java)
    }


    private fun postData() {
//        val inputData = arguments?.getString("LoanType")
        val etTesting:EditText = requireView().findViewById(R.id.etTesting)
        val inputData = etTesting.text.toString()
        val requestData = MyBlockchainApi.RequestData(inputData!!)
        GlobalScope.launch(Dispatchers.IO) {
            try {
                val response = myApi.PostData(kldFromValue, requestData).execute()

                if (response.isSuccessful) {
                    GlobalScope.launch(Dispatchers.Main) {
                        etTesting.text.clear()
                        Toast.makeText(requireContext(), "Data posted", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    GlobalScope.launch(Dispatchers.Main) {
                        Toast.makeText(requireContext(), "Data not posted", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            } catch (e: Exception) {
                GlobalScope.launch(Dispatchers.Main) {
                    Toast.makeText(requireContext(), e.message, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

}