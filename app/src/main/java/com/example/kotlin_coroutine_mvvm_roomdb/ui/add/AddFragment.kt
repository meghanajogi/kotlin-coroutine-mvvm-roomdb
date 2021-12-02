package com.example.kotlin_coroutine_mvvm_roomdb.ui.add

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.kotlin_coroutine_mvvm_roomdb.R
import com.example.kotlin_coroutine_mvvm_roomdb.databinding.FragmentAddBinding
import com.example.kotlin_coroutine_mvvm_roomdb.model.User
import com.example.kotlin_coroutine_mvvm_roomdb.viewmodel.UserViewModel


class AddFragment : Fragment() {
    private lateinit var binding:FragmentAddBinding
    private lateinit var mUserViewModel: UserViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_add, container, false)
        return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        binding.saveBtn.setOnClickListener {
            insertDataToDatabase()
        }
    }
    private fun insertDataToDatabase() {
        val firstName = binding.addFirstNameEt.text.toString()
        val lastName = binding.addLastNameEt.text.toString()
        val email = binding.addEmailEt.text.toString()

        if(inputCheck(firstName, lastName, email)){
            // Create User Object
            val user = User(
                0,
                firstName,
                lastName,
                email)

            // Add Data to Database
            mUserViewModel.addUser(user)
            Toast.makeText(requireContext(), "Successfully added!", Toast.LENGTH_LONG).show()
            // Navigate Back
            findNavController().navigate(R.id.action_addFragment_to_userListFragment)
        }else{
            Toast.makeText(requireContext(), "Please fill out all fields.", Toast.LENGTH_LONG).show()
        }
    }
    private fun inputCheck(firstName: String, lastName: String, age: String): Boolean{
        return !(TextUtils.isEmpty(firstName) && TextUtils.isEmpty(lastName) && age.isEmpty())
    }
}