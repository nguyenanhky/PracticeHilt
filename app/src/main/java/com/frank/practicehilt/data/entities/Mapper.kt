package com.frank.practicehilt.data.entities

import com.frank.practicehilt.data.database.question.QuestionEntity


/**
 * convert QuestionEntity to Question
 */
fun QuestionEntity.toQuestion(): Question {
    return Question(
        title = this.title,
        questionId = this.questionId
    )
}

fun List<QuestionEntity>.toListQuestion(): List<Question> {
    return this.map {
        it.toQuestion()
    }
}

/**
 * convert Question to QuestionEntity
 */

fun Question.toQuestionEntity(): QuestionEntity {
    return QuestionEntity(
        title = this.title,
        questionId = this.questionId
    )
}

fun List<Question>.toQuestionEntity(): List<QuestionEntity> {
    return this.map {
        it.toQuestionEntity()
    }
}
