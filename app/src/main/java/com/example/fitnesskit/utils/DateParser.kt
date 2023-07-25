package com.example.fitnesskit.utils

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun String.toLocalDate(): LocalDate = LocalDate.parse(this, DateTimeFormatter.ofPattern("yyyy-MM-dd"))


fun LocalDate.asString(): String = format(DateTimeFormatter.ofPattern("dd MMMM"))
