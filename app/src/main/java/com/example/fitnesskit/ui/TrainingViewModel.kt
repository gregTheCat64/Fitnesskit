package com.example.fitnesskit.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.insertSeparators
import androidx.paging.map
import com.example.fitnesskit.db.AppDb
import com.example.fitnesskit.entity.TrainingWithCoachAndTabEntity
import com.example.fitnesskit.models.DateSeparator
import com.example.fitnesskit.models.Training
import com.example.fitnesskit.models.TrainingItem
import com.example.fitnesskit.models.TrainingWithCoachAndTab
import com.example.fitnesskit.repo.Repository
import com.example.fitnesskit.repo.RepositoryImpl
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import java.lang.Exception
import java.time.LocalDate
import kotlin.random.Random

class TrainingViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: Repository =
        RepositoryImpl(AppDb.getInstance(context = application).dao())

    val data: Flow<PagingData<TrainingItem>> = repository
        .data
        .map {
            it.insertSeparators { after, before ->
                if (after == null || before == null){
                    return@insertSeparators null
                }
                val afterDate = after.training.date
                val beforeDate = before.training.date
                if (afterDate > beforeDate){
                    DateSeparator(afterDate)
                } else null
            }
        }



    init {
        println("init VM")
        loadData()

    }

    private fun loadData() = viewModelScope.launch {
        println("loading data")
        try {
            repository.getAll()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}