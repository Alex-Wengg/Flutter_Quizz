package com.example.quizz_app

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.database.Cursor;


public class PostsDatabaseHelper extends SQLiteOpenHelper {
    // Database Info
    private val  String DATABASE_NAME = "quiz_database";
    private val  int DATABASE_VERSION = 1;

    // Table Names
    private val  String TABLE_QUESTIONS = "questions";
    private static final String TABLE_CHOICES = "choices";
    private static final String TABLE_USERS = "users";

    // Questions Table Columns
    private static final String QUESTION_ID = "id";
    private static final String QUESTION_TEXT = "text";
    private static final String QUESTION_TITLE = "title";

    // Choice Table Columns
    private static final String CHOICE_ID = "id";
    private static final String CHOICE_TEXT = "text";
    private static final String CHOICE_ANSWER = "answer";
    private static final String QUESTION_ID_FK = "questionId";

    private static PostsDatabaseHelper sInstance;

    public static synchronized PostsDatabaseHelper getInstance(Context context) {
        // Use the application context to keep Activity's context safe.
        if (sInstance == null) {
            sInstance = new PostsDatabaseHelper(context.getApplicationContext());
        }
        return sInstance;
    }

    
    // Constructor should be private to prevent direct instantiation.
    // Make a call to the static method "getInstance()"
    private PostsDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    
    // Called when the database connection is being configured.
    // Configure database settings for things like foreign key support, write-ahead logging, etc.
    @Override
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
        db.setForeignKeyConstraintsEnabled(true);
    }

    // Called when the database is created for the FIRST time else not called
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_QUESTIONS_TABLE = "CREATE TABLE " + TABLE_QUESTIONS +
                " (" +
                    QUESTION_ID + " INTEGER PRIMARY KEY, " + // Define a primary key
                    QESTION_TEXT + " TEXT NOT NULL, " ,
                    QESTION_TITLE + " TEXT NOT NULL, " +
                ")";

        String CREATE_CHOICE_TABLE = "CREATE TABLE " + TABLE_CHOICES +
                " (" +
                    CHOICE_ID + " INTEGER PRIMARY KEY, " +
                    CHOICE_TEXT + " TEXT NOT NULL, " +
                    CHOICE_ANSWER + " BOOLEAN NOT NULL, " +
                    "FOREIGN KEY (" + QUESTION_ID_FK + ") INTEGER REFERENCE " + TABLE_QUESTIONS + " (" + QUESTION_ID + " )" // Define a foreign key
                " )";

        db.execSQL(CREATE_QUESTIONS_TABLE);
        db.execSQL(CREATE_CHOICES_TABLE);
    }
    
    // Called when the database needs to be upgraded.
    //  if a database NAME exists but DATABASE_VERSION != database that exists on disk.
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            // Simplest implementation is to drop all old tables and recreate them
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUESTIONS);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_CHOICES);
            onCreate(db);
        }
    }

    // Insert a post into the database
    public void addPost(Question question) {
        // Create and/or open the database for writing
        SQLiteDatabase db = getWritableDatabase();

        // It's a good idea to wrap our insert in a transaction. This helps with performance and ensures
        // consistency of the database.
        db.beginTransaction();
        try {

            ContentValues questionData = new ContentValues();
            questionData.put(QUESTION_TITLE, question.title);
            questionData.put(QUESTION_TEXT, question.text);
            long questionid = db.insertOrThrow(TABLE_QUESTIONS, null, questionData);

            ContentValues choiceData = new ContentValues();
            for ((key, value) in question.choices) {
              questionData.put(CHOICE_TEXT, key);
              questionData.put(CHOICE_ANSWER, value);
              questionData.put(QUESTION_ID_FK, questionid);
              db.insertOrThrow(TABLE_CHOICES, null, choiceData);
            }
            db.setTransactionSuccessful();
        } catch (Exception e) {
            Log.d(TAG, "Error while trying to add post to database");
        } finally {
            db.endTransaction();
        }
    }

    // Get all posts in the database
    public List<Post> getAllPosts() {
        List<Question> questions = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
 
        String GET_QUESTIONS =
                String.format("SELECT * FROM %s",
                        TABLE_QUESTIONS);
        Cursor questionCursor = db.rawQuery(GET_QUESTIONS, null);
        try {
            if (questionCursor.moveToFirst()) {
                do {
                    Question currQuestion = new Question();
                    currQuestion.title = questionCursor.getString(questionCursor.getColumnIndex(QUESTION_TITLE));
                    currQuestion.text = questionCursor.getString(questionCursor.getColumnIndex(QUESTION_TEXT));
                    String questionId = questionCursor.getString(questionCursor.getColumnIndex(QUESTION_ID))
                    
                    // make this a function later
                    String GET_CHOICES =
                                String.format("SELECT * FROM %s WHERE %s.%s = ",
                                        TABLE_CHOICES, TABLE_CHOICES, QUESTION_ID_FK, questionId);
                    Cursor choiceCursor = db.rawQuery(GET_QUESTIONS, null);
                    if (choiceCursor.moveToFirst()) {
                        do {
                          String choiceText = choiceCursor.getString(choiceCursor.getColumnIndex(CHOICE_TEXT));
                          Boolean choiceAnswer = choiceCursor.getString(choiceCursor.getColumnIndex(CHOICE_ANSWER));
                          currQuestion.choice.put(choiceText, choiceAnswer)
                        } while(choiceCursor.moveToNext());
                    }

                    questions.add(currQuestion);
                } while(questionCursor.moveToNext());
            }
        } catch (Exception e) {
            Log.d(TAG, "Error while trying to get posts from database");
        } finally {
            if (questionCursor != null && !questionCursor.isClosed()) {
                questionCursor.close();
            }
        }
        return questions;
    }

    // Delete all database
    public void purgeAll() {
        SQLiteDatabase db = getWritableDatabase();
        db.beginTransaction();
        try {
            // Order of deletions is important when foreign key relationships exist.
            db.delete(TABLE_POSTS, null, null);
            db.delete(TABLE_USERS, null, null);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            Log.d(TAG, "Error while trying to delete all posts and users");
        } finally {
            db.endTransaction();
        }
    }    
}