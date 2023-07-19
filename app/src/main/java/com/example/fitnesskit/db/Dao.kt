package com.example.fitnesskit.db


import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.fitnesskit.entity.CoachEntity
import com.example.fitnesskit.entity.FitnessObjectEntity
import com.example.fitnesskit.entity.OptionEntity
import com.example.fitnesskit.entity.TabsEntity
import com.example.fitnesskit.entity.TrainingEntity
import com.example.fitnesskit.entity.TrainingItem
import com.example.fitnesskit.entity.TrainingWithCoachAndTab
import com.example.fitnesskit.models.FitnessObject
import kotlinx.coroutines.flow.Flow


@Dao
interface Dao {


    @Query("SELECT * FROM trainings")
    fun pagingSource(): PagingSource<Int,TrainingItem>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTrainings(trainings: List<TrainingEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCoaches(coaches: List<CoachEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTabs(tabs: List<TabsEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOption(optionEntity: OptionEntity)


    suspend fun insertAllTables(
        trainings: List<TrainingEntity>,
        coaches: List<CoachEntity>,
        tabs: List<TabsEntity>,
        optionEntity: OptionEntity
    ) {
        insertCoaches(coaches)
        insertTabs(tabs)
        insertOption(optionEntity)
        insertTrainings(trainings)

    }
}