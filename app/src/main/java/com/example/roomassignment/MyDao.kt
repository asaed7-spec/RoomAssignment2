package com.example.roomassignment

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface MyDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addCourse(course: Course)

    @Query("SELECT * FROM course_table ORDER BY id ASC")
    fun readAllData(): Flow<List<Course>>

    @Update
    suspend fun updateCourse(course: Course)

    @Delete
    suspend fun deleteCourse(course: Course)

    @Query("DELETE FROM course_table")
    suspend fun deleteAllCourses()
}