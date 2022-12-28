package com.example.quizz_app

data class Question(
    val title: String,

    val text: String,

    val choices: HashMap<String, Boolean>
    
)