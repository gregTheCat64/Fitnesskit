package com.example.fitnesskit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.fitnesskit.entity.TrainingWithCoachAndTab

class TrainingsAdapter :
    ListAdapter<TrainingWithCoachAndTab, TrainingsAdapter.TrainingsViewHolder>(LessonsDiffCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrainingsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val viewToInflate = R.layout.lesson_item
        return TrainingsViewHolder(inflater.inflate(viewToInflate, parent, false))
    }


    override fun onBindViewHolder(holder: TrainingsViewHolder, position: Int) {
        val item = getItem(position)
        with(holder.itemView) {
            findViewById<TextView>(R.id.lessonTitle).text = item.training?.name
            findViewById<TextView>(R.id.coachName).text = item.coach?.name
            findViewById<TextView>(R.id.startTime).text = item.training?.startTime
            findViewById<TextView>(R.id.endTime).text = item.training?.endTime
            findViewById<TextView>(R.id.location).text = item.training?.place
        }
    }

    class TrainingsViewHolder(
        view: View
    ) : RecyclerView.ViewHolder(view)
}

class LessonsDiffCallback : DiffUtil.ItemCallback<TrainingWithCoachAndTab>() {
    override fun areItemsTheSame(
        oldItem: TrainingWithCoachAndTab,
        newItem: TrainingWithCoachAndTab
    ): Boolean {
        return oldItem.training?.appointment_id == newItem.training?.appointment_id
    }

    override fun areContentsTheSame(
        oldItem: TrainingWithCoachAndTab,
        newItem: TrainingWithCoachAndTab
    ): Boolean {
        return oldItem == newItem
    }

}