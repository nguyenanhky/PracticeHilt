package com.frank.practicehilt.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.frank.practicehilt.data.entities.QuestionEntity

@Dao
interface QuestionDao {

    @Insert
    suspend fun insertAll(questions: List<QuestionEntity>)

    @Query("SELECT * FROM question")
    suspend fun getAll(): List<QuestionEntity>

    @Query("DELETE FROM question")
    suspend fun deleteAll()

}