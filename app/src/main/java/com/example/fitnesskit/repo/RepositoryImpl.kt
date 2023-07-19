package com.example.fitnesskit.repo

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.fitnesskit.ApiError
import com.example.fitnesskit.api.Api
import com.example.fitnesskit.db.Dao
import com.example.fitnesskit.entity.TrainingItem
import com.example.fitnesskit.entity.TrainingWithCoachAndTab
import com.example.fitnesskit.models.toEntity
import kotlinx.coroutines.flow.Flow
import kotlin.Exception

class RepositoryImpl(private val dao: Dao): Repository {
    private val apiService = Api.service
    override val data: Flow<PagingData<TrainingItem>> = Pager(
        config = PagingConfig(5),
        pagingSourceFactory = dao::pagingSource
    ).flow

    override suspend fun getAll() {
        Log.i("fitTag","loading in repo" )
        try {
            val response = apiService.getLessons()
            if (!response.isSuccessful){
                throw ApiError(response.code(), response.message())
            }
            val body = response.body() ?: throw Error()
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