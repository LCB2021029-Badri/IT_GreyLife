package com.example.credit_risk_eval_badri_v01.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.credit_risk_eval_badri_v01.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

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


        return rootView
    }

}