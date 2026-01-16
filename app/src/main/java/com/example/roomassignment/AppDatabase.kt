package com.example.roomassignment

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

// تعريف الجداول والإصدار
@Database(entities = [Course::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun myDao(): MyDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        // وظيفة لجلب نسخة واحدة فقط من قاعدة البيانات (Singleton)
        fun getDatabase(context: Context): AppDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "course_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}