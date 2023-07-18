package com.example.fitnesskit.repo

import androidx.lifecycle.LiveData
import com.example.fitnesskit.entity.TrainingWithCoachAndTab

interface Repository {
    val data: LiveData<List<TrainingWithCoachAndTab>>
    suspend fun getAll()
    suspend fun getById(id: String)
}