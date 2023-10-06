package com.example.credit_risk_eval_badri_v01.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.credit_risk_eval_badri_v01.R
import com.example.credit_risk_eval_badri_v01.adapters.LoanTypeAdapter
import com.example.credit_risk_eval_badri_v01.adapters.PersonalityAssessmentAdapter
import com.example.credit_risk_eval_badri_v01.data.LoanTypeModel
import com.example.credit_risk_eval_badri_v01.data.PersonalityAssessmentQuestionModel
import com.example.credit_risk_eval_badri_v01.databinding.ActivityHomeScreenBinding

class HomeScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeScreenBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var loanTypeAdapter: LoanTypeAdapter
    private lateinit var loanTypeList: ArrayList<LoanTypeModel>
    private lateinit var score:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        enableBottomNavView()
        enableRecyclerView()


        score = intent.getStringExtra("testScore")!!
        binding.tvTestScore.text = score

    }


    private fun enableRecyclerView(){
        recyclerView = binding.recyclerView
        loanTypeList = ArrayList()
        loanTypeList.add(LoanTypeModel("Tractor", R.drawable.ic_tractor))
        loanTypeList.add(LoanTypeModel("2-Wheeler", R.drawable.ic_scooter))
        loanTypeList.add(LoanTypeModel("Used Cars", R.drawable.ic_car))
        loanTypeList.add(LoanTypeModel("3-Wheeler", R.drawable.ic_auto))
        loanTypeAdapter = LoanTypeAdapter(loanTypeList,this)
        recyclerView.adapter = loanTypeAdapter

    }

    private fun enableBottomNavView(){
        val bottomNavigationView = binding.bottomNavigation
        bottomNavigationView.setSelectedItemId(R.id.homeScreen)
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.statusScreen -> {
                    startActivity(Intent(applicationContext, StatusScreenActivity::class.java))
                    finish()
                    overridePendingTransition(0, 0)
                    true
                }
                R.id.homeScreen -> true
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


}