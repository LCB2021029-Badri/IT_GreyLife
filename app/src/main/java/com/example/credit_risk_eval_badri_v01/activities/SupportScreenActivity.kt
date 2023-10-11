package com.example.credit_risk_eval_badri_v01.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.credit_risk_eval_badri_v01.R
import com.example.credit_risk_eval_badri_v01.adapters.MessageAdapter
import com.example.credit_risk_eval_badri_v01.databinding.ActivityStatusScreenBinding
import com.example.credit_risk_eval_badri_v01.databinding.ActivitySupportScreenBinding
import com.example.credit_risk_eval_badri_v01.models.MessageModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.util.Date

class SupportScreenActivity : AppCompatActivity() {


//    private var LENDER_ID = "0Rl5g5tbbLfZl9DV5GGlsrmxZKq1"
    private lateinit var binding: ActivitySupportScreenBinding
    private lateinit var database: FirebaseDatabase
    private lateinit var senderUid:String
    private lateinit var receiverUid:String
    private lateinit var senderUidMergedReceiverUid:String
    private lateinit var receiverUidMergedSenderUid:String
    private lateinit var list:ArrayList<MessageModel>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySupportScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        database = FirebaseDatabase.getInstance()
        senderUid = FirebaseAuth.getInstance().uid.toString()
        receiverUid = "0Rl5g5tbbLfZl9DV5GGlsrmxZKq1"
        senderUidMergedReceiverUid = senderUid+receiverUid
        receiverUidMergedSenderUid = receiverUid+senderUid
        list = ArrayList()


        enableBottomNavView()

        binding.btnSend.setOnClickListener {
            if(binding.etMessage.text.isEmpty()){
                //do nothing
            }
            else{
                //store in DB
                saveChatToDatabase()
            }

        }

        loadChatFromDatabase()





    }

    private fun enableBottomNavView(){
        val bottomNavigationView = binding.bottomNavigation
        bottomNavigationView.setSelectedItemId(R.id.supportScreen)
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.homeScreen -> {
                    startActivity(Intent(applicationContext, HomeScreenActivity::class.java))
                    finish()
                    overridePendingTransition(0, 0)
                    true
                }
                R.id.supportScreen -> true
                R.id.statusScreen -> {
                    startActivity(Intent(applicationContext, StatusScreenActivity::class.java))
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

    private fun loadChatFromDatabase(){
        database.reference.child("chats")
            .child(senderUidMergedReceiverUid)
            .child("message")
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    list.clear()
                    for(snapshot1 in snapshot.children){
                        val data = snapshot1.getValue(MessageModel::class.java)
                        list.add(data!!)
                    }

                    binding.rvChat.adapter = MessageAdapter(this@SupportScreenActivity,list)

                }

                override fun onCancelled(error: DatabaseError) {
                    //toast message
                }

            })
    }

    private fun saveChatToDatabase(){
        val message = MessageModel(binding.etMessage.text.toString(),senderUid, Date().time)
        val randomKey = database.reference.push().key
        database.reference.child("chats")
            .child(senderUidMergedReceiverUid)
            .child("message")
            .child(randomKey!!)
            .setValue(message)
            .addOnSuccessListener {
                //if data saved successful for sender then we must save it in receiver also
                database.reference.child("chats")
                    .child(receiverUidMergedSenderUid)
                    .child("message")
                    .child(randomKey!!)
                    .setValue(message)
                    .addOnSuccessListener {
                        //message sent successfully
                        binding.etMessage.text = null
                    }
            }
    }

}