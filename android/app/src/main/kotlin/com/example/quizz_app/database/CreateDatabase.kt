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
		// below is a sqlite query, where column names
		// along with their data types is given


		val queryQuestion = ("CREATE TABLE " + DESCRIPT_TABLE_NAME + " ("
				+ DESCRIPT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
				+ DESCRIPT_TEXT + " TEXT NOT NULL "+")")

		val queryChoice = ("CREATE TABLE " + CHOICE_TABLE_NAME + " ("
				+ CHOICE_ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
				+ ANSWER_COL + " TEXT NOT NULL, "
				+ CORRECT_COL + " BOOLEAN NOT NULL, " 
				+ DESCRIPT_ID + " INTEGER NOT NULL, "
				+ "FOREIGN KEY (" + DESCRIPT_ID + ") REFERENCES " + DESCRIPT_TABLE_NAME + " (" + DESCRIPT_ID + ") "
				+")")
		// we are calling sqlite
		// method for executing our query
		db.execSQL(queryQuestion)
		db.execSQL(queryChoice)

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
		values.put(DESCRIPT_TEXT, text)
 
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

	companion object{
		// here we have defined variables for our database

		// below is variable for database name
		private val DATABASE_NAME = "QUESTION"

		// below is the variable for database version
		private val DATABASE_VERSION = 1

		// below is the variable for table name
		val DESCRIPT_TABLE_NAME = "description_table"
		val DESCRIPT_ID = "descriptionid"
		val DESCRIPT_TEXT = "description"

    val CHOICE_TABLE_NAME = "choice_table"
    val CHOICE_ID_COL = "choiceid"
    val ANSWER_COL = "answer"
    val CORRECT_COL = "correct"
	}
}
