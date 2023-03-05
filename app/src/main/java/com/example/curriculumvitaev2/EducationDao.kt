package com.example.curriculumvitaev2

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query


@Dao
interface EducationDao {

    @Query("SELECT * FROM Education")
    fun getAll(): List<Education>

    @Insert
    fun create(t: Education)

    @Query("SELECT * FROM Education WHERE id = :id")
    fun getOne(id: Int): Education

    @Delete
    fun deleteOne(t: Education)
}