package com.example.quizz_app

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context, factory: SQLiteDatabase.CursorFactory?) :
	 
	SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION) {
 


	// below is the method for creating a database by a sqlite query
	override fun onCreate(db: SQLiteDatabase) {
		//merge question and choice classes to one 
		   	   val  questiondbHandler = QuestionTable(this, null);
    	   val  choicedbHandler = ChoiceTable(this, null);
		// below is a sqlite query, where column names
		// along with their data types is given
 


	}

	override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int) {
		// this method is to check if table already exists
		db.execSQL("DROP TABLE IF EXISTS " + DATABASE_NAME)
		onCreate(db)
	}

	// This method is for adding data in our database
	fun addQuestion(name : String, age : String ){ 

		// below we are creating
		// a content values variable
		val values = ContentValues()

		// we are inserting our values
		// in the form of key-value pair
		// values.put(DESCRIPT_TEXT, name)
 
		// our database as we want to
		// insert value in our database
		val db = this.writableDatabase

		// all values are inserted into database

		// at last we are
		// closing our database
		db.close()
	}

	// below method is to get
	// // all data from our database
	// fun getName(): Cursor? {

	// 	// as we want to read value from it
	// 	val db = this.readableDatabase
	// }

	 
}
