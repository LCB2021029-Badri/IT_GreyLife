package com.example.credit_risk_eval_badri_v01.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.credit_risk_eval_badri_v01.R
import com.example.credit_risk_eval_badri_v01.adapters.ClientStatusAdapter
import com.example.credit_risk_eval_badri_v01.databinding.ActivityClientStatusScreenBinding
import com.example.credit_risk_eval_badri_v01.models.UserModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ClientStatusScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivityClientStatusScreenBinding
    private lateinit var database: FirebaseDatabase
    private lateinit var userList : ArrayList<UserModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityClientStatusScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        enableBottomNavView()
        getUserListFromDatabaseAndSetToRecyclerView()

    }


    private fun enableBottomNavView(){
        val bottomNavigationView = binding.bottomNavigation
        bottomNavigationView.setSelectedItemId(R.id.statusScreen)
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.documentsScreen -> {
                    startActivity(Intent(applicationContext, ClientDocumentsScreenActivity::class.java))
                    finish()
                    overridePendingTransition(0, 0)
                    true
                }
                R.id.statusScreen -> true
                R.id.supportScreen -> {
                    startActivity(Intent(applicationContext, ClientSupportScreenActivity::class.java))
                    finish()
                    overridePendingTransition(0, 0)
                    true
                }
                else -> false
            }
        }
    }


    private fun getUserListFromDatabaseAndSetToRecyclerView(){
        database = FirebaseDatabase.getInstance()
        userList = ArrayList()

        database.reference.child("users")
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    userList.clear()
                    for(snapshot1 in snapshot.children){
                        val user = snapshot1.getValue(UserModel::class.java)
                        if(user!!.uid != FirebaseAuth.getInstance().uid){
                            userList.add(user)
                        }
                    }

                    //update the RV adapter with the new userList if data changes
                    binding.userListRecyclerView.adapter = ClientStatusAdapter(this@ClientStatusScreenActivity,userList)

                }

                override fun onCancelled(error: DatabaseError) {

                }

            })
    }

}