package com.example.fitnesskit.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.fitnesskit.TrainingsAdapter
import com.example.fitnesskit.R
import com.example.fitnesskit.databinding.FragmentMainBinding
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainFragment: Fragment(R.layout.fragment_main) {

    lateinit var binding: FragmentMainBinding

    private val viewModel: TrainingViewModel by viewModels(ownerProducer = ::requireParentFragment)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainBinding.bind(view)

        val adapter = TrainingsAdapter()
        binding.list.adapter = adapter


        lifecycleScope.launch{
            viewModel.data.collectLatest (adapter::submitData)
        }


    }
}