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
        val question:TextView = view.findViewById(R.id.question)

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
        val activity = activity as? PersonalityAssessmentActivity

        //-----------------------------------------------------------------------
        question.text = activity!!.questions[qnumber][0]
        option0.text = activity!!.questions[qnumber][1]
        option1.text = activity!!.questions[qnumber][2]
        option2.text = activity!!.questions[qnumber][3]
        option3.text = activity!!.questions[qnumber][4]
        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.option0 -> {
                    activity?.questions?.get(qnumber)?.set(5, "0")
                    testing.text = activity!!.questions[qnumber][5]
                }
                R.id.option1 -> {
                    activity?.questions?.get(qnumber)?.set(5, "1")
                    testing.text = activity!!.questions[qnumber][5]
                }
                R.id.option2 -> {
                    activity?.questions?.get(qnumber)?.set(5, "2")
                    testing.text = activity!!.questions[qnumber][5]
                }
                R.id.option3 -> {
                    activity?.questions?.get(qnumber)?.set(5, "3")
                    testing.text = activity!!.questions[qnumber][5]
                }
            }
        }

        testing.text = activity!!.questions[qnumber][5]




        return view
    }



//    fun updateArrayInMainActivity(newData: String) {
//        val activity = activity as? PersonalityAssessmentActivity
//        activity?.questions.add(newData)
//        // You can now modify the array in MainActivity
//    }


}