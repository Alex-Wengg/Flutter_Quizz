// package com.example.quizz_app

// import android.content.ContentValues
// import android.content.Context
// import android.database.Cursor
// import android.database.sqlite.SQLiteDatabase
// import android.database.sqlite.SQLiteOpenHelper

// class QuestionTable(context: Context, factory: SQLiteDatabase.CursorFactory?) :
// 	SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION) {

// 	// below is the method for creating a database by a sqlite query
// 	override fun onCreate(db: SQLiteDatabase) {

// 		val queryquestion = ("CREATE TABLE " + QUESTION_TABLE_NAME + " ("
// 				+ QUESTION_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
// 				+ QUESTION_TEXT + " TEXT NOT NULL, "
// 				+ THEME + " TEXT NOT NULL "+")")

// 		// method for executing our query
// 		db.execSQL(queryquestion)
// 	}

// 	override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int) {
// 		// this method is to check if table already exists
// 		db.execSQL("DROP TABLE IF EXISTS " + QUESTION_TABLE_NAME)
// 		onCreate(db)
// 	}

// 	// This method is for adding data in our database
// 	fun addQuestion(text : String){

// 		val values = ContentValues()
// 		// we are inserting key-value pair value
// 		values.put(QUESTION_TEXT, text)

// 		// here we are creating a
// 		// writable db variable
// 		val db = this.writableDatabase

// 		db.insert(QUESTION_TABLE_NAME, null, values)

// 		db.close()
// 	}

// 	// below method is to get
// 	// all data from our database
// 	fun getall(): Cursor? {
// 		val db = this.readableDatabase

// 		// read data from the database
// 		return db.rawQuery("SELECT * FROM " + QUESTION_TABLE_NAME, null)

// 	}

// }
