package com.example.fitnesskit.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.fitnesskit.TrainingsAdapter
import com.example.fitnesskit.R
import com.example.fitnesskit.databinding.FragmentMainBinding

class MainFragment: Fragment(R.layout.fragment_main) {

    lateinit var binding: FragmentMainBinding

    private val viewModel: TrainingViewModel by viewModels(ownerProducer = ::requireParentFragment)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainBinding.bind(view)



        val adapter = TrainingsAdapter()
        binding.list.adapter = adapter



        viewModel.data.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }


    }
}