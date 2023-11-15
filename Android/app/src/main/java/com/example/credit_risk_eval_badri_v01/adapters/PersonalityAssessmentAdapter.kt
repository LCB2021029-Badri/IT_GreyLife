package com.example.credit_risk_eval_badri_v01.adapters

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.example.credit_risk_eval_badri_v01.R
import com.example.credit_risk_eval_badri_v01.activities.PersonalityAssessmentActivity
import com.example.credit_risk_eval_badri_v01.models.PersonalityAssessmentQuestionModel
import com.example.credit_risk_eval_badri_v01.fragments.PersonalityQuestionDesctiptionFragment

class PersonalityAssessmentAdapter(private val questionsList:ArrayList<PersonalityAssessmentQuestionModel>, private val activity: PersonalityAssessmentActivity):RecyclerView.Adapter<PersonalityAssessmentAdapter.QuestionsViewHolder>(){
    class QuestionsViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){
        val qNo:TextView = itemView.findViewById(R.id.qNo)
        val layout: RelativeLayout = itemView.findViewById(R.id.layout)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_personality_assessment_item,parent,false)
        return QuestionsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return questionsList.size
    }

    var index = -1
    override fun onBindViewHolder(holder: QuestionsViewHolder, position: Int) {
        val question = questionsList[position]
        holder.qNo.text = question.qNo
        holder.itemView.setOnClickListener (object:View.OnClickListener{
            override fun onClick(p0: View?) {
                val activity = p0!!.context as AppCompatActivity
                val questionFragment = PersonalityQuestionDesctiptionFragment()

                //try
                val bundle = Bundle()
                bundle.putString("key", question.qNo)
                questionFragment.arguments = bundle

//                activity.supportFragmentManager.beginTransaction()
//                    .replace(R.id.fragmentContainerView,questionFragment)
//                    .addToBackStack(null)
//                    .commit()

                val fragmentManager = activity.supportFragmentManager

                // Clear the back stack before replacing the current fragment
                fragmentManager.popBackStackImmediate(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)

                val transaction = fragmentManager.beginTransaction()
                transaction.replace(R.id.fragmentContainerView, questionFragment)
                transaction.commit()

                index = position
                notifyDataSetChanged()
            }

        })

        if(index == position){
            holder.qNo.setTextColor(Color.BLACK)
        }
        else{
            //
            holder.qNo.setTextColor(Color.BLACK)
        }

        val activity = activity as? PersonalityAssessmentActivity
        if(activity!!.questions[position][5]=="null"){
            holder.layout.setBackgroundColor(Color.parseColor("#FDFDFD"))
            if(index == position){
                holder.layout.setBackgroundColor(Color.parseColor("#FDD962"))
            }
            if(index == position){
//                holder.qNo.setTextColor(Color.BLACK)
                holder.qNo.setTextColor(Color.parseColor("#165485"))
            }
            else{
                //
                holder.qNo.setTextColor(Color.BLACK)
            }
        }
        else{
            holder.qNo.setTextColor(Color.parseColor("#FDFDFD"))
            holder.layout.setBackgroundColor(Color.parseColor("#308E2D"))
            if(index == position){
                holder.layout.setBackgroundColor(Color.parseColor("#FDD962"))
                holder.qNo.setTextColor(Color.BLACK)
            }

        }

    }
}