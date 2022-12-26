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

		val queryDescription = ("CREATE TABLE " + TABLE_NAME + " ("
				+ DESCRIPT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
				+ DESCRIPT_TEXT + " TEXT NOT NULL "+")")

		// method for executing our query
		db.execSQL(queryDescription)
	}

	override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int) {
		// this method is to check if table already exists
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME)
		onCreate(db)
	}

	// This method is for adding data in our database
	fun addQuestion(text : String){

		val values = ContentValues()
		// we are inserting key-value pair value
		values.put(DESCRIPT_TEXT, text)

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
		val TABLE_NAME = "description_table"
		val DESCRIPT_ID = "descriptionid"
		val DESCRIPT_TEXT = "description"

    val CHOICE_TABLE_NAME = "choice_table"
    val CHOICE_ID_COL = "choiceid"
    val ANSWER_COL = "answer"
    val CORRECT_COL = "correct"
	}
}
