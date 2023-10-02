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
       val view =  inflater.inflate(
            R.layout.fragment_personality_question_desctiption,
            container,
            false
       )


        radioGroup = view.findViewById(R.id.radioGroup)
        val option0:RadioButton = view.findViewById(R.id.option0)
        val option1:RadioButton = view.findViewById(R.id.option1)
        val option2:RadioButton = view.findViewById(R.id.option2)
        val option3:RadioButton = view.findViewById(R.id.option3)
        val option4:RadioButton = view.findViewById(R.id.option4)

//        val questionNo:TextView = view.findViewById(R.id.questionNo)
//        questionNo.text = data.toString()
        val testing:TextView = view.findViewById(R.id.testing)
//        Toast.makeText(requireContext(), "Hello, Option0", Toast.LENGTH_SHORT).show()
7
        //-----------------------------------------------------------------------
        val data = arguments?.getString("key")
        val qnumber = data!!.toInt()
        val questionNoFromBundle:TextView = view.findViewById(R.id.qnofrombundle)
        questionNoFromBundle.text = data.toString()

        //-----------------------------------------------------------------------
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

        //-----------------------------------------------------------------------
        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.option0 -> {
                    questions[qnumber][6] = "0"
                    testing.text = questions[qnumber][6]
                }
                R.id.option1 -> {
                    questions[qnumber][6] = "1"
                    testing.text = questions[qnumber][6]
                }
                R.id.option2 -> {
                    questions[qnumber][6] = "2"
                    testing.text = questions[qnumber][6]
                }
                R.id.option3 -> {
                    questions[qnumber][6] = "3"
                    testing.text = questions[qnumber][6]
                }
                R.id.option4 -> {
                    questions[qnumber][6] = "4"
                    testing.text = questions[qnumber][6]
                }
            }
        }

//        testing.text = questions[qnumber][6]





        return view
    }


}