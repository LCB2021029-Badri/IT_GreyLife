package com.example.credit_risk_eval_badri_v01.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.credit_risk_eval_badri_v01.R
import com.example.credit_risk_eval_badri_v01.activities.PersonalityAssessmentActivity

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
//        val questions = arrayOf(
//            arrayOf("q1","opt1","opt2","opt2","opt4","opt5","null"),
//            arrayOf("q2","opt1","opt2","opt2","opt4","opt5","null"),
//            arrayOf("q3","opt1","opt2","opt2","opt4","opt5","null"),
//            arrayOf("q4","opt1","opt2","opt2","opt4","opt5","null"),
//            arrayOf("q5","opt1","opt2","opt2","opt4","opt5","null"),
//            arrayOf("q6","opt1","opt2","opt2","opt4","opt5","null"),
//            arrayOf("q7","opt1","opt2","opt2","opt4","opt5","null"),
//            arrayOf("q8","opt1","opt2","opt2","opt4","opt5","null"),
//            arrayOf("q9","opt1","opt2","opt2","opt4","opt5","null"),
//            arrayOf("q10","opt1","opt2","opt2","opt4","opt5","null"),
//        )



        val activity = activity as? PersonalityAssessmentActivity

        //-----------------------------------------------------------------------
        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.option0 -> {
                    activity?.questions?.get(qnumber)?.set(6, "0")
                    testing.text = activity!!.questions[qnumber][6]
                }
                R.id.option1 -> {
                    activity?.questions?.get(qnumber)?.set(6, "1")
                    testing.text = activity!!.questions[qnumber][6]
                }
                R.id.option2 -> {
                    activity?.questions?.get(qnumber)?.set(6, "2")
                    testing.text = activity!!.questions[qnumber][6]
                }
                R.id.option3 -> {
                    activity?.questions?.get(qnumber)?.set(6, "3")
                    testing.text = activity!!.questions[qnumber][6]
                }
                R.id.option4 -> {
                    activity?.questions?.get(qnumber)?.set(6, "4")
                    testing.text = activity!!.questions[qnumber][6]
                }
            }
        }

        testing.text = activity!!.questions[qnumber][6]




        return view
    }



//    fun updateArrayInMainActivity(newData: String) {
//        val activity = activity as? PersonalityAssessmentActivity
//        activity?.questions.add(newData)
//        // You can now modify the array in MainActivity
//    }


}