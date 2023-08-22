package com.example.fitnesskit

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.fitnesskit.databinding.HeaderItemBinding
import com.example.fitnesskit.databinding.LessonItemBinding
import com.example.fitnesskit.models.DateSeparator
import com.example.fitnesskit.models.TrainingItem
import com.example.fitnesskit.models.TrainingWithCoachAndTab
import com.example.fitnesskit.utils.asString
import java.lang.IllegalArgumentException

class TrainingsAdapter :
    PagingDataAdapter<TrainingItem, RecyclerView.ViewHolder>(LessonsDiffCallback()) {
    private val typeHeader = 0
    private val typeTraining = 1

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)){
            is TrainingWithCoachAndTab -> typeTraining
            is DateSeparator -> typeHeader
            null -> throw IllegalArgumentException("unknown item type: ${getItem(position)}")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return when (viewType){
            typeTraining -> TrainingsViewHolder(LessonItemBinding.inflate(inflater, parent, false))
            typeHeader -> HeaderViewHolder(HeaderItemBinding.inflate(inflater, parent, false))
            else -> throw IllegalArgumentException("unknown view type: $viewType")
        }
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (val item = getItem(position)){
            is DateSeparator -> (holder as HeaderViewHolder).bind(item)
            is TrainingWithCoachAndTab -> (holder as TrainingsViewHolder).bind(item)
            else -> throw IllegalArgumentException("unknown view type")
        }
    }

    class TrainingsViewHolder(
        private val binding: LessonItemBinding
    ) : RecyclerView.ViewHolder(binding.root){
        fun bind(training: TrainingWithCoachAndTab){
            binding.lessonTitle.text = training.training.name
            binding.coachName.text = training.coach?.name?:"Без тренера"
            binding.startTime.text = training.training.startTime
            binding.endTime.text = training.training.endTime
            binding.location.text = training.training.place
            binding.dateOfTraining.text = training.training.date.asString()
            binding.categoryLine.setBackgroundColor(Color.parseColor(training.training.color))
        }
    }

    class HeaderViewHolder(private val binding: HeaderItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(separator: DateSeparator){
            binding.dateTextView.text = separator.date.asString()
        }
    }
}

class LessonsDiffCallback : DiffUtil.ItemCallback<TrainingItem>() {
    override fun areItemsTheSame(
        oldItem: TrainingItem,
        newItem: TrainingItem
    ): Boolean {
        return if (oldItem is TrainingWithCoachAndTab && newItem is TrainingWithCoachAndTab)
            oldItem.training.appointment_id == newItem.training.appointment_id else {
            oldItem.date == newItem.date
        }
    }

    override fun areContentsTheSame(
        oldItem: TrainingItem,
        newItem: TrainingItem
    ): Boolean {
        return oldItem == newItem
    }

}