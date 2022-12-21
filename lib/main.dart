import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

import 'package:quizz_app/screens/main_menu.dart';

import 'package:quizz_app/screens/kotlin_backend.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
        home: const MyHomePage(title: 'Flutter Demo Home Page'),
        routes: {
          '/second': (context) =>
              const MyHomePage(title: 'Flutter Demo Home Page')
        });
  }
}
