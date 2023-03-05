package com.example.curriculumvitaev2

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase



@Database(entities = [Experience::class, Education::class], version = 1, exportSchema = false)
abstract class AppDataBase : RoomDatabase() {

    abstract fun experienceDao(): ExperienceDao
    abstract fun educationDao(): EducationDao

    //  abstract fun experienceDao(): Any

    companion object {
        @Volatile
        private var instance: AppDataBase? = null

        fun getDatabase(context: Context): AppDataBase {
            if (instance == null) {
                synchronized(this) {
                    instance = Room.databaseBuilder(
                        context,
                        AppDataBase::class.java,
                        "CVdatabase-db"
                    )
                        .allowMainThreadQueries()
                        .build()
                }
            }
            return instance!!
        }
    }
}


