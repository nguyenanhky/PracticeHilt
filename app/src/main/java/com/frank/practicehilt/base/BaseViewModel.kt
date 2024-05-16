package com.frank.practicehilt.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.frank.practicehilt.common.Logger
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Job

open class BaseViewModel : ViewModel() {

    protected var parentJob: Job? = null

    var isLoading = MutableLiveData(false)
        private set

    protected fun registerEventParentJobFinish() {
        parentJob?.invokeOnCompletion {
            isLoading.postValue(false)
        }
    }

    var exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        Logger.log("Exception ${throwable.message}")
    }
}