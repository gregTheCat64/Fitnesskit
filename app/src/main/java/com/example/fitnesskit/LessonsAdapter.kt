package com.example.fitnesskit

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fitnesskit.databinding.LessonItemBinding
import com.example.fitnesskit.models.Lesson

class LessonsAdapter: RecyclerView.Adapter<LessonsAdapter.LessonsViewHolder>() {

    var lessons: List<Lesson> = emptyList()
        set(newValue) {
            field = newValue
            notifyDataSetChanged()
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LessonsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = LessonItemBinding.inflate(inflater, parent,false)
        return LessonsViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return lessons.size
    }

    override fun onBindViewHolder(holder: LessonsViewHolder, position: Int) {
        val lesson = lessons[position]
        with(holder.binding){
            lessonTitle.text = lesson.name
            coachName.text = lesson.coach_id
            startTime.text = lesson.startTime
            endTime.text = lesson.endTime
            location.text = lesson.place
        }
    }

    class LessonsViewHolder(
        val binding: LessonItemBinding
    ): RecyclerView.ViewHolder(binding.root)
}