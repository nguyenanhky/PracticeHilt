package com.frank.practicehilt.data.repositories

import com.frank.practicehilt.data.entities.Question
import com.frank.practicehilt.data.entities.QuestionList
import com.frank.practicehilt.data.services.QuestionRemoteService
import com.frank.practicehilt.di.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class QuestionRepository @Inject constructor(
    private val remoteService: QuestionRemoteService,
    @IoDispatcher private val dispatcher: CoroutineDispatcher,
) {

    suspend fun getListQuestion(): List<Question> = withContext(dispatcher) {
        getNewAndSave()
    }

    private suspend fun getNewAndSave(): List<Question> {
        val questionList = remoteService.getListQuestion(currentPage = 1, pageSize = 1)
        val newListQuestion = questionList?.items ?: emptyList()
        return newListQuestion
    }

}