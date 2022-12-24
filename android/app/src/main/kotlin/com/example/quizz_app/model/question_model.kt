package com.example.quizz_app

data class Question(
    val question: String,
    val answers: HashMap<String, Boolean>
    
)