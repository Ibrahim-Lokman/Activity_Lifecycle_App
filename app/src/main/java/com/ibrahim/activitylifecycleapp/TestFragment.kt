package com.ibrahim.activitylifecycleapp

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ibrahim.activitylifecycleapp.databinding.FragmentTestBinding

class TestFragment : Fragment() {

     private lateinit var binding : FragmentTestBinding


        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding.textViewFragmentText.text = "Fragment Text: onCreate "
        }
        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            binding = FragmentTestBinding.inflate(inflater, container, false)
            return binding.root
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
           binding.textViewFragmentText.text = "Fragment Text: onViewCreated "
        }


}