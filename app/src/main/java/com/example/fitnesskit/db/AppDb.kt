package com.example.fitnesskit.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.fitnesskit.entity.CoachEntity
import com.example.fitnesskit.entity.OptionEntity
import com.example.fitnesskit.entity.TabsEntity
import com.example.fitnesskit.entity.TrainingEntity

@Database(
    entities = [
        TrainingEntity::class,
        CoachEntity::class,
        TabsEntity::class,
        OptionEntity::class
    ], version = 1, exportSchema = false
)
//@TypeConverter()
abstract class AppDb : RoomDatabase() {
    abstract fun dao(): Dao

    companion object {
        @Volatile
        private var instance: AppDb? = null

        fun getInstance(context: Context): AppDb {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context, AppDb::class.java, "app.db")
                .fallbackToDestructiveMigration()
                .build()
    }
}