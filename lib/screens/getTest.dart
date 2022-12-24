import 'package:flutter/services.dart';
import 'package:flutter/material.dart';
import 'package:quizz_app/model/question_model.dart';
import 'dart:convert';

class MyHomePage extends StatefulWidget {
  const MyHomePage({super.key});
  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  String receivedJson = "";
  List<dynamic> questions = [];
  int question_pos = 0;
  int score = 0;
  bool btnPressed = false;
  PageController? _controller;
  String btnText = "Next Question";
  bool answered = false;
  static const platform = MethodChannel('example.com/channel');
  Future<void> _generateRandomNumber() async {
    List<Object?> getQuestions;

    receivedJson = await platform.invokeMethod('test');
    setState(() {
      questions = json.decode(receivedJson);

      print("testing setstate " + (questions.length).toString());
    });
  }

  @override
  void initState() {
    // TODO: implement initState
    super.initState();
    _controller = PageController(initialPage: 0);
    _generateRandomNumber();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        backgroundColor: Color.fromARGB(255, 0, 255, 38),
        body: Center(
            child: Column(children: <Widget>[
          Container(
            padding: EdgeInsets.fromLTRB(20, 20, 20, 20),
            child: Text("Welcome to Javatpoint" + (questions).toString()),
          ),
        ])));
  }
}
