package com.example.curriculumvitaev2

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Date

@Entity
data class Education(

    val id: Int? = 0,
    val image: String,
    val universityName: String,
    val universityAddress: String,
    val startDate: Date,
    val endDate: Date
)