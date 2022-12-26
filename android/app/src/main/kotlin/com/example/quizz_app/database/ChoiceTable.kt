package com.example.quizz_app

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DescriptionTable(context: Context, factory: SQLiteDatabase.CursorFactory?) :
	SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION) {

	// below is the method for creating a database by a sqlite query
	override fun onCreate(db: SQLiteDatabase) {

  val queryChoice = ("CREATE TABLE " + CHOICE_TABLE_NAME + " ("
          + CHOICE_ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
          + ANSWER_COL + " TEXT NOT NULL, "
          + CORRECT_COL + " BOOLEAN NOT NULL, " 
          + DESCRIPT_ID + " INTEGER NOT NULL, "
          + "FOREIGN KEY (" + DESCRIPT_ID + ") REFERENCES " + DESCRIPT_TABLE_NAME + " (" + DESCRIPT_ID + ") "
          +")")

		// method for executing our query
		db.execSQL(queryChoice)
	}

	override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int) {
		// this method is to check if table already exists
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME)
		onCreate(db)
	}

	// This method is for adding data in our database
	fun addChoice(text : String, trueorfalse: Boolean){

		val values = ContentValues()
		// we are inserting key-value pair value
		values.put(ANSWER, text)
		values.put(CORRECT, trueorfalse)

		// here we are creating a
		// writable db variable
		val db = this.writableDatabase

		db.insert(TABLE_NAME, null, values)

		db.close()
	}

	// below method is to get
	// all data from our database
	fun getall(): Cursor? {
		val db = this.readableDatabase

		// read data from the database
		return db.rawQuery("SELECT * FROM " + TABLE_NAME, null)

	}

	companion object{
		// here we have defined variables for our database

		// below is variable for database name
		private val DATABASE_NAME = "QUESTION"

		// below is the variable for database version
		private val DATABASE_VERSION = 1

		// below is the variable for table name
 
    val TABLE_NAME = "choice_table"
    val CHOICE_ID = "choiceid"
    val ANSWER = "answer"
    val CORRECT = "correct"

		val DESCRIPT_ID = "descriptionid"

	}
}
