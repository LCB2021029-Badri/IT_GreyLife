package com.example.credit_risk_eval_badri_v01.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.credit_risk_eval_badri_v01.R
import com.example.credit_risk_eval_badri_v01.adapters.PersonalityAssessmentAdapter
import com.example.credit_risk_eval_badri_v01.data.PersonalityAssessmentQuestionModel
import com.example.credit_risk_eval_badri_v01.databinding.ActivityPersonalityAssessmentBinding

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

        questionsAdapter = PersonalityAssessmentAdapter(questionsList)
        recyclerView.adapter = questionsAdapter
    }


}