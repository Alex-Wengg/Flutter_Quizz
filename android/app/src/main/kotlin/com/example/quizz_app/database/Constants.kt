    
package com.example.quizz_app

const val DATABASE_NAME: String = "quiz_database"
const val DATABASE_VERSION: Int = 1

// questions database
const val QUESTION_TABLE_NAME: String = "question_table"
const val QUESTION_ID: String = "question_id"
const val QUESTION_TEXT: String = "question_text"

const val THEME = "quiz_theme"

// database for multiple choices, contain text and T/F
const val TABLE_NAME: String = "choice_table"
const val CHOICE_ID: String = "choice_id"
const val ANSWER: String = "answer"
const val CORRECT: String = "correct"
