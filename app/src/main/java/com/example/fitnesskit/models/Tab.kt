package com.example.fitnesskit.models

import com.example.fitnesskit.entity.TabsEntity

data class Tab(
    val id: Int,
    val name: String
)

fun Tab.toEntity() = TabsEntity(id, name)