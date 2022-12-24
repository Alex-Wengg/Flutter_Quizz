import 'dart:async';
import 'package:flutter/services.dart';

class QuestionModel {
  String question;
  Map<String, bool> answers;
  QuestionModel(this.question, this.answers);

  // a MethodChannel instance _channel with channel name question
  static const MethodChannel _channel = // 1
      const MethodChannel("question");

  // Future<T> allow for async
  static Future<String?> get platformVersion async {
    final String? version =
        // invokeMethod( <plugin-method-name>, [args]) bridge kotlin data
        await _channel.invokeMethod('getPlatformVersion'); // 3
    return version; // 4
  }

  static Future<String?> onKeyUp(int key) async {
    final String? returnQuestion =
        await _channel.invokeMethod('getQuestions', [key]); // 3
    return returnQuestion; // 4
  }

  static Future<Map<String, bool>?> getChoices(int key) async {
    final Map<String, bool>? returnChoices =
        await _channel.invokeMethod('getChoices', [key]); // 2
    return returnChoices; // 3
  }
}
