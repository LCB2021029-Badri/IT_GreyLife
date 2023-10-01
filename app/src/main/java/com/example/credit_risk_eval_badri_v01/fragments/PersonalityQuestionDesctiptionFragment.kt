package com.example.credit_risk_eval_badri_v01.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.credit_risk_eval_badri_v01.R

class PersonalityQuestionDesctiptionFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       val rootView =  inflater.inflate(
            R.layout.fragment_personality_question_desctiption,
            container,
            false
       )

        val data = arguments?.getString("key")
        val questionNo:TextView = rootView.findViewById(R.id.questionNo)
        questionNo.text = data.toString()

        val questionNoFromBundle:TextView = rootView.findViewById(R.id.qnofrombundle)
        questionNoFromBundle.text = data.toString()





        return rootView
    }

}