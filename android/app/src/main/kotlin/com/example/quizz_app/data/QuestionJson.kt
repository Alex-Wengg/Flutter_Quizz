package com.example.quizz_app

// import com.example.model.Question

object setDataJson {

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

        // // 2
        // val que2 = Question(
        //   "When does a cat purr ?",
        //   hashMapOf(
        //     "When it cares for its kittens" to false,
        //     "When it needs confort" to false,
        //     "When it feels content" to false,
        //     "All of the above" to true,
        //   )
        // )

        // questionsList.add(que2)

        // // 3
        // val que3 = Question(
        //   "What is the averge nulber of kittens in a litter ?",
        //   hashMapOf(
        //     "1 to 2" to false,
        //     "3 to 5" to true,
        //     "8 to 10" to false,
        //     "12 to 14" to false,
        //   )
        // )

        // questionsList.add(que3)

        // // 4
        // val que4 = Question(
        //     "How many moons does Mars have ?",
        //     hashMapOf(
        //       "1" to false,
        //       "2" to false,
        //       "4" to true,
        //       "8" to false,
        //     )
        // )

        // questionsList.add(que4)

        // // 5
        // val que5 = Question(
        //   "What is Mars's nickname ?",
        //   hashMapOf(
        //     "The red planet" to true,
        //     "The dusty planet" to false,
        //     "The hot planet" to false,
        //     "The smelly planet" to false,
        //   )  
        // )

        // questionsList.add(que5)

        // // 6
        // val que6 = Question(
        //     6, "What country does this flag belong to?",
        //     R.drawable.ic_flag_of_germany,
        //     "Germany", "Georgia",
        //     "Greece", "none of these", 1
        // )

        // questionsList.add(que6)

        // // 7
        // val que7 = Question(
        //     7, "What country does this flag belong to?",
        //     R.drawable.ic_flag_of_denmark,
        //     "Dominica", "Egypt",
        //     "Denmark", "Ethiopia", 3
        // )

        // questionsList.add(que7)

        // // 8
        // val que8 = Question(
        //     8, "What country does this flag belong to?",
        //     R.drawable.ic_flag_of_india,
        //     "Ireland", "Iran",
        //     "Hungary", "India", 4
        // )

        // questionsList.add(que8)

        // // 9
        // val que9 = Question(
        //     9, "What country does this flag belong to?",
        //     R.drawable.ic_flag_of_new_zealand,
        //     "Australia", "New Zealand",
        //     "Tuvalu", "United States of America", 2
        // )

        // questionsList.add(que9)

        // // 10
        // val que10 = Question(
        //     10, "What country does this flag belong to?",
        //     R.drawable.ic_flag_of_kuwait,
        //     "Kuwait", "Jordan",
        //     "Sudan", "Palestine", 1
        // )

        // questionsList.add(que10)

        return questionsList
    }
}