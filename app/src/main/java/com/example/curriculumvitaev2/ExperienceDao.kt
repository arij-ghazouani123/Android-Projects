package com.example.curriculumvitaev2

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ExperienceDao{

    @Query("SELECT * FROM Experience")
     fun getAll(): List<Experience>

    @Insert
     fun create(t: Experience)

    @Query("SELECT * FROM Experience WHERE id = :id")
    fun getOne(id: Int): Experience

    @Delete
   fun deleteOne(t: Experience)
}