package com.example.quizz_app

// import com.example.model.Question

object setData {

    const val name:String="name"
    const val score:String="score"

    // TODO (STEP 1 to Create a constant variables which we required in the result screen.)
    // START
    // const val USER_NAME to String = "user_name"
    // const val TOTAL_QUESTIONS to String = "total_questions"
    // const val CORRECT_ANSWERS to String = "correct_answers"
    // END
    
    fun getQuestions(): ArrayList<Question> {

        val questionsList = ArrayList<Question>()

        // // 1
        val que1 = Question(
          "How Many Whiskers does the average cat have on each side of its face ?",
          hashMapOf("1" to false, 
                    "3" to false, 
                    "12" to true,
                    "5" to false)
        )
        questionsList.add(que1)

        // 2
        val que2 = Question(
          "When does a cat purr ?",
          hashMapOf(
            "When it cares for its kittens" to false,
            "When it needs confort" to false,
            "When it feels content" to false,
            "All of the above" to true,
          )
        )

        questionsList.add(que2)

        // 3
        val que3 = Question(
          "What is the averge nulber of kittens in a litter ?",
          hashMapOf(
            "1 to 2" to false,
            "3 to 5" to true,
            "8 to 10" to false,
            "12 to 14" to false,
          )
        )

        questionsList.add(que3)

        // 4
        val que4 = Question(
            "How many moons does Mars have ?",
            hashMapOf(
              "1" to false,
              "2" to false,
              "4" to true,
              "8" to false,
            )
        )

        questionsList.add(que4)

        // 5
        val que5 = Question(
          "What is Mars's nickname ?",
          hashMapOf(
            "The red planet" to true,
            "The dusty planet" to false,
            "The hot planet" to false,
            "The smelly planet" to false,
          )  
        )

        questionsList.add(que5)

  
        return questionsList
    }
}