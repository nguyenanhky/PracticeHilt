package com.frank.practicehilt.data.services

import com.frank.practicehilt.data.database.dao.QuestionDao
import com.frank.practicehilt.data.entities.QuestionEntity
import javax.inject.Inject

class QuestionLocalService @Inject constructor(
    private val questionDao: QuestionDao,
) {

    suspend fun deleteAllQuestion() {
        questionDao.deleteAll()
    }

    suspend fun getAllQuestion(): List<QuestionEntity> {
        return questionDao.getAll()
    }

    suspend fun saveListQuestion(questions: List<QuestionEntity>) {
        questionDao.insertAll(questions)
    }


}