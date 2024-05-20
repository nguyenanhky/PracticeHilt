package com.frank.practicehilt.ui.jsonplaceholder

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.frank.practicehilt.base.BaseViewModel
import com.frank.practicehilt.data.database.post.Post
import com.frank.practicehilt.data.services.PostRemoteService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class JsonPlaceHolderViewModel @Inject constructor(
    private val postRemoteService: PostRemoteService,
) : BaseViewModel() {


    var latestPost = MutableLiveData<Post>()
        protected set

    fun getAllPosts() {
        parentJob = viewModelScope.launch(exceptionHandler) {
            isLoading.postValue(true)
            val posts = postRemoteService.getPosts()
            posts?.firstOrNull()?.let { post ->
                latestPost.postValue(post)
            }
        }
        registerEventParentJobFinish()
    }


}