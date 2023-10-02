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


        val questions = arrayOf(
            arrayOf("q1","opt1","opt2","opt2","opt4","opt5","null"),
            arrayOf("q2","opt1","opt2","opt2","opt4","opt5","null"),
            arrayOf("q3","opt1","opt2","opt2","opt4","opt5","null"),
            arrayOf("q4","opt1","opt2","opt2","opt4","opt5","null"),
            arrayOf("q5","opt1","opt2","opt2","opt4","opt5","null"),
            arrayOf("q6","opt1","opt2","opt2","opt4","opt5","null"),
            arrayOf("q7","opt1","opt2","opt2","opt4","opt5","null"),
            arrayOf("q8","opt1","opt2","opt2","opt4","opt5","null"),
            arrayOf("q9","opt1","opt2","opt2","opt4","opt5","null"),
            arrayOf("q10","opt1","opt2","opt2","opt4","opt5","null"),
        )

        questionsAdapter = PersonalityAssessmentAdapter(questionsList)
        recyclerView.adapter = questionsAdapter

    }



}