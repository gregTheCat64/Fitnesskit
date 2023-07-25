package com.example.fitnesskit.repo

import android.util.Log
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.example.fitnesskit.ApiError
import com.example.fitnesskit.api.Api
import com.example.fitnesskit.db.Dao
import com.example.fitnesskit.entity.TrainingWithCoachAndTabEntity
import com.example.fitnesskit.models.TrainingItem
import com.example.fitnesskit.models.TrainingWithCoachAndTab
import com.example.fitnesskit.models.toEntity
import com.example.fitnesskit.models.toModel
import com.example.fitnesskit.response.toEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlin.Exception

class RepositoryImpl(private val dao: Dao): Repository {
    private val apiService = Api.service

    override val data: Flow<PagingData<TrainingWithCoachAndTab>> = Pager(
        config = PagingConfig(5),
        pagingSourceFactory = dao::pagingSource
    ).flow.map { pagingData ->
        pagingData.map{
            it.toModel()
        }
    }

    override suspend fun getAll() {
        println("loading in repo")
        try {
            val response = apiService.getLessons()
            println("BODY: ${response.isSuccessful}")
            if (!response.isSuccessful){
                throw ApiError(response.code(), response.message())
            }
            val body = response.body() ?: throw Error()
            //println("BODY: ${body.trainings}")

            dao.insertAllTables(
                body.trainings.map { it.toEntity() },
                body.coaches.map { it.toEntity() },
                body.tabs.map { it.toEntity() },
                body.option.toEntity()
                )
        } catch (e: Exception){
            e.printStackTrace()
        }

    }

    override suspend fun getById(id: String) {

    }
}