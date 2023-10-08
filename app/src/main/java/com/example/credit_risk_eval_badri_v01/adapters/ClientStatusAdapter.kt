package com.example.credit_risk_eval_badri_v01.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.credit_risk_eval_badri_v01.R
import com.example.credit_risk_eval_badri_v01.activities.ClientUpdateStatusActivity
import com.example.credit_risk_eval_badri_v01.databinding.ClientStatusUserItemLayoutBinding
import com.example.credit_risk_eval_badri_v01.models.UserModel

class ClientStatusAdapter(var context: Context, var list:ArrayList<UserModel>) : RecyclerView.Adapter<ClientStatusAdapter.StatusViewHolder>() {

    inner class StatusViewHolder(view: View) : RecyclerView.ViewHolder(view){
        var binding : ClientStatusUserItemLayoutBinding = ClientStatusUserItemLayoutBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StatusViewHolder {
        return StatusViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.client_status_user_item_layout,parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: StatusViewHolder, position: Int) {
        val user = list[position]
        //set the profile
        //Glide.with(context).load(user.imageUrl).into(holder.binding.userImage)
        holder.binding.userName.text = user.name
        holder.binding.userId.text = user.uid
        holder.binding.userEmail.text = user.email
//        holder.binding.tvStatus.text = status from blockchain (or ml model if block chain integration fails)

        //on click
        holder.itemView.setOnClickListener {
            val intent = Intent(context, ClientUpdateStatusActivity::class.java)
            intent.putExtra("uid",user.uid)
            context.startActivity(intent)
        }

    }
}