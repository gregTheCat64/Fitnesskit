package com.example.fitnesskit.ui

import android.app.Application
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.fitnesskit.App
import java.lang.IllegalStateException

class ViewModelFactory(
    private val application: Application
): ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
          val viewModel = when(modelClass) {
              TrainingViewModel::class.java -> {
                  TrainingViewModel(application)
              }

              else -> {
                  throw  IllegalStateException("Unknown view model class")
              }
          }
        return viewModel as T
    }
}

fun Fragment.factory() = ViewModelFactory(requireContext().applicationContext as Application)