package com.example.kotlin_coroutine_mvvm_roomdb.ui.onboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.kotlin_coroutine_mvvm_roomdb.R
import com.example.kotlin_coroutine_mvvm_roomdb.databinding.FragmentOnboardScreenBinding

class OnboardScreenFragment : Fragment() {
  private lateinit var binding:FragmentOnboardScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_onboard_screen, container, false)
        return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.startBtn.setOnClickListener {
            findNavController().navigate(R.id.action_onboardScreenFragment_to_loginFragment)
        }
    }


}