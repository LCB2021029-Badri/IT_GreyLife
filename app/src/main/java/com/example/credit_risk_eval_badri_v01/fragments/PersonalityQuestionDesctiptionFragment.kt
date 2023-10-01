package com.example.credit_risk_eval_badri_v01.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import com.example.credit_risk_eval_badri_v01.R

class PersonalityQuestionDesctiptionFragment : Fragment() {

    private lateinit var radioGroup: RadioGroup

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       val view =  inflater.inflate(
            R.layout.fragment_personality_question_desctiption,
            container,
            false
       )

        val data = arguments?.getString("key")
        val questionNo:TextView = view.findViewById(R.id.questionNo)
        questionNo.text = data.toString()
        val questionNoFromBundle:TextView = view.findViewById(R.id.qnofrombundle)
        questionNoFromBundle.text = data.toString()


        val testing:TextView = view.findViewById(R.id.testing)
        val option1:RadioButton = view.findViewById(R.id.option1)

        //
        radioGroup = view.findViewById(R.id.radioGroup)
        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.option0 -> {
                    Toast.makeText(requireContext(), "Hello, Option0", Toast.LENGTH_SHORT).show()
                }
                R.id.option1 -> {
                    testing.text = option1.text.toString()
                }
                R.id.option2 -> {

                }
                R.id.option3 -> {

                }R.id.option4 -> {

            }
            }
        }






        return view
    }


}