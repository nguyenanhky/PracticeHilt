package com.frank.practicehilt.data.repositories

import com.frank.practicehilt.data.entities.Question
import com.frank.practicehilt.data.entities.toListQuestion
import com.frank.practicehilt.data.entities.toQuestionEntity
import com.frank.practicehilt.data.services.QuestionLocalService
import com.frank.practicehilt.data.services.QuestionRemoteService
import com.frank.practicehilt.di.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class QuestionRepository @Inject constructor(
    private val remoteService: QuestionRemoteService,
    private val localService: QuestionLocalService,
    @IoDispatcher private val dispatcher: CoroutineDispatcher,
) {

    suspend fun getListQuestion(): List<Question> = withContext(dispatcher) {
        val savedQuestion = localService.getAllQuestion()
        if (savedQuestion.isNotEmpty()) {
            savedQuestion.toListQuestion()
        } else {
            getNewAndSave()
        }
    }

    private suspend fun getNewAndSave(): List<Question> {
        val questionList = remoteService.getListQuestion(currentPage = 1, pageSize = 1)
        val newListQuestion = questionList?.items ?: emptyList()
        if (newListQuestion.isNotEmpty()) {
            localService.deleteAllQuestion()
            localService.saveListQuestion(newListQuestion.toQuestionEntity())
        }
        return newListQuestion
    }

    suspend fun refresh(): List<Question> = withContext(dispatcher) {
        getNewAndSave()
    }
}