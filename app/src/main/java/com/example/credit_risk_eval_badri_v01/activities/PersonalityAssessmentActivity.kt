package com.example.credit_risk_eval_badri_v01.activities

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.credit_risk_eval_badri_v01.R
import com.example.credit_risk_eval_badri_v01.adapters.PersonalityAssessmentAdapter
import com.example.credit_risk_eval_badri_v01.data.PersonalityAssessmentQuestionModel
import com.example.credit_risk_eval_badri_v01.databinding.ActivityPersonalityAssessmentBinding
import org.json.JSONArray

class PersonalityAssessmentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPersonalityAssessmentBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var questionsList: ArrayList<PersonalityAssessmentQuestionModel>
    private lateinit var questionsAdapter: PersonalityAssessmentAdapter

//    val questions = arrayOf(
//        arrayOf("q1","opt1","opt2","opt2","opt4","opt5","null"),
//        arrayOf("q2","opt1","opt2","opt2","opt4","opt5","null"),
//        arrayOf("q3","opt1","opt2","opt2","opt4","opt5","null"),
//        arrayOf("q4","opt1","opt2","opt2","opt4","opt5","null"),
//        arrayOf("q5","opt1","opt2","opt2","opt4","opt5","null"),
//        arrayOf("q6","opt1","opt2","opt2","opt4","opt5","null"),
//        arrayOf("q7","opt1","opt2","opt2","opt4","opt5","null"),
//        arrayOf("q8","opt1","opt2","opt2","opt4","opt5","null"),
//        arrayOf("q9","opt1","opt2","opt2","opt4","opt5","null"),
//        arrayOf("q10","opt1","opt2","opt2","opt4","opt5","null"),
//    )

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


        questionsAdapter = PersonalityAssessmentAdapter(questionsList)
        recyclerView.adapter = questionsAdapter

    }

//    fun getQuestiuons():Array<Array<String>>{
//        return questions
//    }



}