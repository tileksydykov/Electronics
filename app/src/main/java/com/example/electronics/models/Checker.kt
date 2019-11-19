package com.example.electronics.models

import com.google.firebase.database.IgnoreExtraProperties


@IgnoreExtraProperties
data class Checker(
    val id: Long,
    val name: String,
    val auditorium: String
)