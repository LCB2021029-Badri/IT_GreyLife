package com.example.credit_risk_eval_badri_v01.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.credit_risk_eval_badri_v01.R
import com.example.credit_risk_eval_badri_v01.data.PersonalityAssessmentQuestionModel

class PersonalityAssessmentAdapter(private val questionsList:ArrayList<PersonalityAssessmentQuestionModel>):RecyclerView.Adapter<PersonalityAssessmentAdapter.QuestionsViewHolder>(){
    class QuestionsViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){
        val qNo:TextView = itemView.findViewById(R.id.qNo)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_personality_assessment_item,parent,false)
        return QuestionsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return questionsList.size
    }

    override fun onBindViewHolder(holder: QuestionsViewHolder, position: Int) {
        val question = questionsList[position]
        holder.qNo.text = question.qNo
    }
}