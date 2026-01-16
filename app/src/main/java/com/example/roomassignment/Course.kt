package com.example.roomassignment

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "course_table")
data class Course(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val courseName: String,
    val courseCode: String
)