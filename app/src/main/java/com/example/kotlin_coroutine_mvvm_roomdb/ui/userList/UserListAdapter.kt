package com.example.kotlin_coroutine_mvvm_roomdb.ui.userList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_coroutine_mvvm_roomdb.R
import com.example.kotlin_coroutine_mvvm_roomdb.model.User

class UserListAdapter: RecyclerView.Adapter<UserListAdapter.MyViewHolder>() {

    private var userList = emptyList<User>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var userId=itemView.findViewById<TextView>(R.id.id_txt)
        var firstName=itemView.findViewById<TextView>(R.id.firstName_txt)
        var lastName=itemView.findViewById<TextView>(R.id.lastName_txt)
        var email=itemView.findViewById<TextView>(R.id.email)
        var rowLayout=itemView.findViewById<ConstraintLayout>(R.id.rowLayout)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_row, parent, false))
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = userList[position]
        holder.firstName.text = currentItem.firstName.toString()
        holder.userId.text = currentItem.id.toString()
        holder.lastName.text = currentItem.lastName
        holder.email.text = currentItem.email


        holder.rowLayout.setOnClickListener {
           // val action = ListFragmentDirections.actionListFragmentToUpdateFragment(currentItem)
            holder.itemView.findNavController().navigate(R.id.action_userListFragment_to_addFragment)
        }
    }

    fun setData(user: List<User>){
        this.userList = user
        notifyDataSetChanged()
    }
}