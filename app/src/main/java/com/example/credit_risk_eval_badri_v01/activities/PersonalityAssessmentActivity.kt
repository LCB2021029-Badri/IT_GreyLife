package com.example.credit_risk_eval_badri_v01.activities

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.credit_risk_eval_badri_v01.R
import com.example.credit_risk_eval_badri_v01.adapters.PersonalityAssessmentAdapter
import com.example.credit_risk_eval_badri_v01.data.PersonalityAssessmentQuestionModel
import com.example.credit_risk_eval_badri_v01.databinding.ActivityPersonalityAssessmentBinding
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar
import org.json.JSONArray

class PersonalityAssessmentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPersonalityAssessmentBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var questionsList: ArrayList<PersonalityAssessmentQuestionModel>
    private lateinit var questionsAdapter: PersonalityAssessmentAdapter
    lateinit var score:String

    val questions = arrayOf(
        arrayOf(
            "How often do you make a detailed budget for your monthly expenses?",
            "Every month",
            "Occasionally",
            "Rarely",
            "Never",
            "null"
        ),
        arrayOf(
            "When you receive unexpected extra income, like a bonus or tax refund, what do you typically do?",
            "Save it for emergencies or future goals",
            "Spend it on non-essential items",
            "Invest it",
            "Pay off debts<",
            "null"
        ),
        arrayOf(
            "How do you feel about taking on debt for major purchases, such as a car or home?",
            "I\'m comfortable with it as long as I can afford the monthly payments",
            "I avoid taking on debt whenever possible ",
            "I prefer to pay for major purchases in cash",
            "I\'m willing to take on debt to get what I want",
            "null"
        ),
        arrayOf(
            "How often do you review your bank account statements and track your expenses?",
            "Every week",
            "Once a month",
            "Rarely",
            "I don\'t typically review my statements",
            "null"
        ),
        arrayOf(
            "What is your attitude toward saving for retirement?",
            "I actively save for retirement and have a plan in place",
            "I save occasionally, but retirement isn\'t a top priority",
            "I don\'t currently save for retirement",
            "I rely on other sources of income for retirement",
            "null"
        ),
        arrayOf(
            "When faced with financial setbacks or unexpected expenses, what is your typical reaction?",
            "I dip into my emergency savings",
            "I borrow money from family or friends",
            "I use credit cards to cover the expenses",
            "I struggle to find a solution",
            "null"
        ),
        arrayOf(
            "How would you describe your risk tolerance when it comes to investments?",
            "Very conservative; I prefer low-risk investments",
            "Moderately conservative; I seek a balance between risk and reward",
            "Moderate risk-taker; I\'m open to some investment risk",
            "Aggressive risk-taker; I\'m willing to take on higher risks for potential returns",
            "null"
        ),
        arrayOf(
            "Do you have a history of missed or late payments on loans or credit cards?",
            "No, I\'ve never missed a payment",
            "Yes, I\'ve missed a payment in the past",
            "I occasionally miss payments",
            "I frequently miss payments",
            "null"
        ),
        arrayOf(
            "q9",
            "opt1",
            "opt2",
            "opt2",
            "opt4",
            "null"
        ),
        arrayOf(
            "q10",
            "opt1",
            "opt2",
            "opt2",
            "opt4",
            "null"
        ),

    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPersonalityAssessmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        enableRecyclerView()
        nextBtn()
    }


    private fun enableRecyclerView(){
        recyclerView = binding.recyclerView
        questionsList = ArrayList()
        questionsList.add(PersonalityAssessmentQuestionModel("1"))
        questionsList.add(PersonalityAssessmentQuestionModel("2"))
        questionsList.add(PersonalityAssessmentQuestionModel("3"))
        questionsList.add(PersonalityAssessmentQuestionModel("4"))
        questionsList.add(PersonalityAssessmentQuestionModel("5"))
        questionsList.add(PersonalityAssessmentQuestionModel("6"))
        questionsList.add(PersonalityAssessmentQuestionModel("7"))
        questionsList.add(PersonalityAssessmentQuestionModel("8"))
        questionsList.add(PersonalityAssessmentQuestionModel("9"))
        questionsList.add(PersonalityAssessmentQuestionModel("10"))


        questionsAdapter = PersonalityAssessmentAdapter(questionsList,this)
        recyclerView.adapter = questionsAdapter

    }

    private fun nextBtn(){

        binding.btnNext.setOnClickListener {
            var flag:Boolean = false
            for(i in 0..9){
                if(questions[i][5]=="null"){
                    flag = true
                    break
                }
            }
            if(flag){
//                Toast.makeText(this,"incomplete questions",Toast.LENGTH_SHORT).show()
                createSnackBar(binding.root, "incomplete questions","Try Again")
                binding.score.text = calculateAssessmentScore().toString()
            }
            else{
                Toast.makeText(this,"completed questions",Toast.LENGTH_SHORT).show()
                score= calculateAssessmentScore().toString()

                val sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
                val editor = sharedPreferences.edit()
                editor.putString("testScore", score)
                editor.apply()

                val intent = Intent(this,HomeScreenActivity::class.java)
//                intent.putExtra("testScore",score)
                startActivity(intent)


            }
        }

    }


    private fun calculateAssessmentScore():Int{
        var ans:Int= 0
        for(i in 0..9){
            val x = questions[i][5]
            if(x=="0"){
                ans+=10
            }
            else if(x=="1"){
                ans+=8
            }
            else if(x=="2"){
                ans+=5
            }
            else if(x=="3"){
                ans+=3
            }
            else{
                ans+=0
            }
        }
        return ans
    }



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




}