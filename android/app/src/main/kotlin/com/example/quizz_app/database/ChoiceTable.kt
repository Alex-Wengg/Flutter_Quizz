package com.example.quizz_app
import com.example.quizz_app.*

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class ChoiceTable(context: Context, factory: SQLiteDatabase.CursorFactory?) :
	SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION) {

	// below is the method for creating a database by a sqlite query
	override fun onCreate(db: SQLiteDatabase) {

  val queryChoice = ("CREATE TABLE " + TABLE_NAME + " ("
          + CHOICE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
          + ANSWER + " TEXT NOT NULL, "
          + CORRECT + " BOOLEAN NOT NULL, " 
          + THEME + " TEXT NOT NULL, "
          + QUESTION_ID + " INTEGER NOT NULL, "
          + "FOREIGN KEY (" + QUESTION_ID + ") REFERENCES " + QUESTION_TABLE_NAME + " (" + QUESTION_ID + ") "
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
}
