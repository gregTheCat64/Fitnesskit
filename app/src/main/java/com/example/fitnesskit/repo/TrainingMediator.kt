package com.example.fitnesskit.repo

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import com.example.fitnesskit.ApiError
import com.example.fitnesskit.api.ApiService
import com.example.fitnesskit.db.AppDb
import com.example.fitnesskit.db.Dao
import com.example.fitnesskit.entity.TrainingWithCoachAndTabEntity
import com.example.fitnesskit.models.toEntity
import com.example.fitnesskit.response.toEntity
import java.lang.Exception

@OptIn(ExperimentalPagingApi::class)
class TrainingMediator(
    private val service: ApiService,
    private val db: AppDb,
    private val dao: Dao
): RemoteMediator<Int, TrainingWithCoachAndTabEntity>() {
    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, TrainingWithCoachAndTabEntity>
    ): MediatorResult {
        try {
            val response = when (loadType) {
                LoadType.REFRESH -> service.getLessons()

                else -> {service.getLessons()}
            }

            if (!response.isSuccessful) throw ApiError(response.code(), response.message())
            val body = response.body() ?: throw ApiError(response.code(), response.message())
            dao.insertTrainings(body.trainings.map { it.toEntity() })
        }catch (e: Exception) {
            return MediatorResult.Error(e)
        }
        return MediatorResult.Success(endOfPaginationReached = false)
    }
}