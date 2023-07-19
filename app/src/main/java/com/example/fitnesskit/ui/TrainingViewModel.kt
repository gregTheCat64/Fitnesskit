package com.example.fitnesskit.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.insertSeparators
import com.example.fitnesskit.db.AppDb
import com.example.fitnesskit.entity.Header
import com.example.fitnesskit.entity.TrainingItem
import com.example.fitnesskit.entity.TrainingWithCoachAndTab
import com.example.fitnesskit.repo.Repository
import com.example.fitnesskit.repo.RepositoryImpl
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import java.lang.Exception

class TrainingViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: Repository =
        RepositoryImpl(AppDb.getInstance(context = application).dao())

    val data: Flow<PagingData<TrainingItem>> = repository
        .data
        .map {
            it.insertSeparators(
                generator = { before, after ->
                    if (before == null) {
                        return@insertSeparators
                    }
                    val afterDateStr = after?.
                    val beforeDateStr = before.training.startTime
                    if (afterDateStr == null || beforeDateStr == null) {
                        return@insertSeparators
                    }


                    if (afterDateStr > beforeDateStr) {
                        Header()
                    } else null
                }
            )
        }.cachedIn(viewModelScope)

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