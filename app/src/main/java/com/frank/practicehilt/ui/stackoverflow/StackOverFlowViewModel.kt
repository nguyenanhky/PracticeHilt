package com.frank.practicehilt.ui.stackoverflow

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.frank.practicehilt.base.BaseViewModel
import com.frank.practicehilt.data.entities.Question
import com.frank.practicehilt.data.repositories.QuestionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StackOverFlowViewModel @Inject constructor(
    private val questionRepository: QuestionRepository,
) : BaseViewModel() {

    var listQuestions = MutableLiveData<List<Question>>()
        private set

    fun fetchData() {
        parentJob = viewModelScope.launch(exceptionHandler){
            isLoading.postValue(true)
            val questions = questionRepository.getListQuestion()
            questions?.let {
                listQuestions.postValue(questions)
            }
        }
        registerEventParentJobFinish()
    }


    fun refresh() {
        parentJob = viewModelScope.launch(exceptionHandler){
            isLoading.postValue(true)
            val question = questionRepository.refresh()
            question?.let {
                listQuestions.postValue(question)
            }
        }
        registerEventParentJobFinish()
    }

}