package com.example.credit_risk_eval_badri_v01.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.credit_risk_eval_badri_v01.R
class BorrowerLoanDetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_borrower_loan_details, container, false)

        val tvLoanType:TextView = view.findViewById(R.id.tvLoanType)
        val etTesting:EditText = view.findViewById(R.id.etTesting)
        val btnNext:Button = view.findViewById(R.id.btnSubmit)
        val data = arguments?.getString("key2")

        tvLoanType.text = data

        btnNext.setOnClickListener {
            if(etTesting.text.isNullOrEmpty()){
                Toast.makeText(requireContext(),"fill all details",Toast.LENGTH_SHORT).show()
            }
            else{
                //store these details in block chain
                uploadDataToBlockChain()
            }
        }


        return view
    }


    private fun uploadDataToBlockChain(){

    }

}