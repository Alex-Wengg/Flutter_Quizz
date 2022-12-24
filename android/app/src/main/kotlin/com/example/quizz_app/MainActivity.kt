package com.example.quizz_app

import kotlin.random.Random
import androidx.annotation.NonNull
import android.content.res.Configuration
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel
import android.util.Log
import android.content.Context


class MainActivity: FlutterActivity() {
  //override the configureFlutterEngine from FlutterActivity to register a 
  //method channel for building a communication line with Dart.
  override fun configureFlutterEngine(@NonNull flutterEngine: FlutterEngine) {
    super.configureFlutterEngine(flutterEngine)
    MethodChannel(flutterEngine.dartExecutor.binaryMessenger, "example.com/channel").setMethodCallHandler {
      call, result ->
        if(call.method == "getRandomNumber") {
          val rand = Random.nextInt(100)
          result.success(rand)
        } else if (call.method == "test") {
          var questionList:List<Question>  = listOf<Question>()

          questionList=setData.getQuestions()
          Log.d("TAG", "message");

          Log.d("TAG",  (questionList.size).toString());

          result.success(questionList)
        }else {
          result.notImplemented()
        }
    }
  }
}