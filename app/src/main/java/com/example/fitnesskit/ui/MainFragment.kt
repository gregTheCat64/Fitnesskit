package com.example.fitnesskit.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.fitnesskit.databinding.FragmentMainBinding

class MainFragment: Fragment() {

    lateinit var binding: FragmentMainBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainBinding.bind(view)
    }
}