package com.frank.practicehilt.data.database.question

import com.squareup.moshi.Json

data class QuestionList(
    val items: List<Question>? = emptyList(),
    @Json(name = "has_more") val hasMore: Boolean
)

data class Question(
    @Json(name = "question_id") val questionId: Int,
    val title: String? = null
)
