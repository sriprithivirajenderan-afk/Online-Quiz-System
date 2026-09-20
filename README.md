# Online Quiz System

## Overview

Online Quiz System is a Java 21-based quiz application designed for practicing and managing online quizzes through an object-oriented design.

The project separates quiz execution, players, questions, question creation, question banks, random quiz generation, administrative functionality, and score tracking into dedicated Java classes.

## Features

- Java 21 based quiz application
- Player management
- Multiple-choice questions
- True/False questions
- Question bank management
- Random quiz generation
- Quiz engine for quiz execution
- Scoreboard for tracking results
- Administrative panel functionality
- Factory-based question creation
- Object-oriented project structure

## Technology Stack

- **Language:** Java 21
- **Programming Concepts:** Object-Oriented Programming
- **Version Control:** Git
- **Repository:** GitHub
- **IDE:** VS Code / Eclipse compatible

## Project Structure

The project is organized around separate classes for different responsibilities:

```text
Online-Quiz-System/
├── AdminPanel.java
├── IQuestionFactory.java
├── MCQQuestion.java
├── Main.java
├── Player.java
├── Question.java
├── QuestionBank.java
├── QuestionFactory.java
├── QuestionType.java
├── QuizEngine.java
├── RandomQuizProvider.java
├── ScoreBoard.java
└── TrueFalseQuestion.java
```

## Core Components

### Quiz Engine

`QuizEngine` handles the core quiz execution logic.

### Question Types

The project includes different question implementations, including:

- Multiple-choice questions
- True/False questions

### Question Factory

`IQuestionFactory` and `QuestionFactory` provide a dedicated mechanism for creating question objects.

### Question Bank

`QuestionBank` is responsible for organizing the available quiz questions.

### Random Quiz Provider

`RandomQuizProvider` provides functionality for generating quizzes using available questions.

### Player

`Player` represents the participant taking the quiz.

### Scoreboard

`ScoreBoard` handles quiz score information and results.

### Admin Panel

`AdminPanel` provides administrative functionality for managing the quiz system.

## Object-Oriented Design

The project demonstrates practical Object-Oriented Programming concepts including:

- Classes and objects
- Encapsulation
- Inheritance
- Abstraction
- Interfaces
- Polymorphism
- Factory-based object creation
- Separation of responsibilities

## How to Run

### Prerequisites

Make sure Java 21 or later is installed.

Check the Java version:

```bash
java -version
```

### Compile

From the project directory:

```bash
javac *.java
```

### Run

```bash
java Main
```

## Project Goals

This project was developed to strengthen practical Java and Object-Oriented Programming skills through a complete quiz application.

It demonstrates:

- Java application development
- Object-oriented software design
- Interface-based design
- Question management
- Quiz execution
- Random question selection
- Score tracking
- Basic application modularity

## Future Enhancements

Possible future improvements include:

- Persistent database storage
- User authentication
- Timer-based quizzes
- Difficulty levels
- Category-based quizzes
- Improved score history
- Graphical user interface
- Automated unit testing
- Maven project structure

## Author

**Sri Prithiviraj**

GitHub: https://github.com/sriprithivirajenderan-afk
