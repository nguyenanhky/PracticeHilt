package com.frank.practicehilt.ui.jsonplaceholder

import androidx.lifecycle.MutableLiveData
import com.frank.practicehilt.base.BaseViewModel
import com.frank.practicehilt.data.database.post.Post


class JsonPlaceHolderViewModel : BaseViewModel() {


    var latestPost = MutableLiveData<Post>()
    protected set

    fun getAllPosts(){

    }


}