package com.example.credit_risk_eval_badri_v01.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.credit_risk_eval_badri_v01.R
import com.example.credit_risk_eval_badri_v01.databinding.ActivityStatusScreenBinding
import com.example.credit_risk_eval_badri_v01.interfaces.MyBlockchainApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.Credentials
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class StatusScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStatusScreenBinding
    private lateinit var myApi: MyBlockchainApi
    val USERNAME = "u0yxvm2kkq"
    val PASSWORD = "t5OvSDtcASGoP6xRLBAfaYGZQ53XG4IpZHjorph3vtA"
    val BASE_URL =
        "https://u0lj156pi7-u0mlmn54wo-connect.us0-aws.kaleido.io/gateways/greylife/0xe18110e266f642686981ba41179709d241eb04cf/"
    val kldFromValue = "0xdbca2ba3f5843a82ad7c811174d001cb51cc329a"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStatusScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        enableBottomNavView()

        //get data from database


    }

    private fun enableBottomNavView(){
        val bottomNavigationView = binding.bottomNavigation
        bottomNavigationView.setSelectedItemId(R.id.statusScreen)
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.homeScreen -> {
                    startActivity(Intent(applicationContext, HomeScreenActivity::class.java))
                    finish()
                    overridePendingTransition(0, 0)
                    true
                }
                R.id.statusScreen -> true
                R.id.supportScreen -> {
                    startActivity(Intent(applicationContext, SupportScreenActivity::class.java))
                    finish()
                    overridePendingTransition(0, 0)
                    true
                }
                R.id.notificationsScreen -> {
                    startActivity(Intent(applicationContext, NotificationsScreenActivity::class.java))
                    finish()
                    overridePendingTransition(0, 0)
                    true
                }
                else -> false
            }
        }
    }


//    private fun retrieveDataFromBlockChain(){
//        retrofitCreate()
//        getData()
//    }
//
//    private fun retrofitCreate() {
//        val credentials = Credentials.basic(
//            USERNAME,
//            PASSWORD
//        )
//        val retrofit = Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .client(
//                //-----------------------
//                OkHttpClient.Builder()
//                    .addInterceptor(HttpLoggingInterceptor().apply {
//                        level = HttpLoggingInterceptor.Level.BODY
//                    })
//                    .addInterceptor { chain ->
//                        val newRequest = chain.request().newBuilder()
//                            .header("Authorization", credentials)
//                            .build()
//                        chain.proceed(newRequest)
//                    }
//                    .build()
//                //------------------------
//            )
//            .build()
//
//        myApi = retrofit.create(MyBlockchainApi::class.java)
//    }
//
//
//
//
//    private fun getData() {
//        GlobalScope.launch(Dispatchers.IO) {
//            try {
//                val response = myApi.getData(kldFromValue).execute()
//
//                if (response.isSuccessful) {
//                    val responseData = response.body()
//                    val output = responseData?.output
//                    GlobalScope.launch(Dispatchers.Main) {
//                        runOnUiThread {
//                            binding.tvDataRetrieved.text = output.toString()
//                        }
//                    }
//                } else {
//                    GlobalScope.launch(Dispatchers.Main) {
//
//                        runOnUiThread {
////                            resultTextView.text = ("Data retrieval failed")
//                            Toast.makeText(this,"Data retrieval failed",
//                                Toast.LENGTH_SHORT).show()
//                        }
//                    }
//                }
//            } catch (e: Exception) {
//                GlobalScope.launch(Dispatchers.Main) {
//                    runOnUiThread {
//                        binding.tvDataRetrieved.text = ("Error: ${e.message}")
//                    }
//                }
//            }
//        }
//    }

}