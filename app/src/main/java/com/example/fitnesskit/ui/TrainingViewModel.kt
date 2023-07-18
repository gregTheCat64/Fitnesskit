package com.example.fitnesskit.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fitnesskit.db.AppDb
import com.example.fitnesskit.entity.TrainingWithCoachAndTab
import com.example.fitnesskit.repo.Repository
import com.example.fitnesskit.repo.RepositoryImpl
import kotlinx.coroutines.launch
import java.lang.Exception

class TrainingViewModel(application: Application): AndroidViewModel(application) {
    private val repository: Repository = RepositoryImpl(AppDb.getInstance(context = application).dao())

    val data: LiveData<List<TrainingWithCoachAndTab>> = repository.data

    init {
        println("init VM")
        loadData()

    }
    private fun loadData() = viewModelScope.launch {
        try {
            repository.getAll()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}