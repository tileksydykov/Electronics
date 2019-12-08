package com.example.electronics.models

import com.google.firebase.database.IgnoreExtraProperties


@IgnoreExtraProperties
data class Checker(
    val id: String,
    val name: String,
    var localName : String,
    val auditorium: String
)