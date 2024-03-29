

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

class Question {
    private String questionText;
    private ArrayList<String> options;
    private int correctOptionIndex;

    public Question(String questionText, ArrayList<String> options, int correctOptionIndex) {
        this.questionText = questionText;
        this.options = options;
        this.correctOptionIndex = correctOptionIndex;
    }

    public String getQuestionText() {
        return questionText;
    }

    public ArrayList<String> getOptions() {
        return options;
    }

    public int getCorrectOptionIndex() {
        return correctOptionIndex;
    }
}

class Quiz {
    private ArrayList<Question> questions;
    private Timer timer;
    private int currentQuestionIndex;
    private int score;
    private boolean timeUp;

    public Quiz(ArrayList<Question> questions) {
        this.questions = questions;
        timer = new Timer();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        score = 0;

        for (Question question : questions) {
            timeUp = false;
            startTimer(10); // 10 seconds timer

            System.out.println("Question " + (currentQuestionIndex + 1) + ": " + question.getQuestionText());
            ArrayList<String> options = question.getOptions();
            for (int j = 0; j < options.size(); j++) {
                System.out.println((j + 1) + ". " + options.get(j));
            }

            if (waitForUserInput(scanner, question)) {
                int userAnswer = scanner.nextInt();

                if (!timeUp && userAnswer == question.getCorrectOptionIndex()) {
                    System.out.println("Correct!");
                    score++;
                } else if (!timeUp) {
                    System.out.println("Incorrect. The correct answer was: " + question.getCorrectOptionIndex());
                } else {
                    System.out.println("Time's up! Moving to the next question.");
                }
            } else {
                System.out.println("Time's up! Moving to the next question.");
            }
            timer.cancel();
            timer.purge();
            currentQuestionIndex++;
        }

        System.out.println("Quiz completed. Your score: " + score + " out of " + questions.size());
    }

    private boolean waitForUserInput(Scanner scanner, Question question) {
        long startTime = System.currentTimeMillis();
        long endTime = startTime + 10000; // 10 seconds

        while (System.currentTimeMillis() < endTime) {
            if (scanner.hasNextInt()) {
                return true;
            }
        }
        return false;
    }

    private void startTimer(int seconds) {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                timeUp = true;
            }
        }, seconds * 1000);
    }
}

public class OnlineQuizPlatform {
    public static void main(String[] args) {
        ArrayList<Question> questions = new ArrayList<>();

        questions.add(new Question("What is the default value of the byte data type in Java?",
                new ArrayList<>(List.of("0", "1", "-1", "Null")), 1));
      
        questions.add(new Question("What is the difference between '==' and '.equals()' in Java?",
                new ArrayList<>(List.of("They are identical", "==' compares references, .equals() compares values",
                        "==' compares values, .equals() compares references", "None of the above")), 3));
        questions.add(new Question("What is the purpose of the 'super' keyword in Java?",
                new ArrayList<>(List.of("To refer to the immediate parent class object", "To call a superclass method",
                        "To create an instance of the superclass", "All of the above")), 4));
        questions.add(new Question("What is the Java Virtual Machine (JVM)?",
                new ArrayList<>(List.of("A compiler", "An interpreter", "A virtual machine that runs Java bytecode",
                        "A tool for debugging Java code")), 3));
        questions.add(new Question("What is the output of 'System.out.println(3 + 5 + \"Java\")'?",
                new ArrayList<>(List.of("35Java", "8Java", "Syntax error", "Java8")), 2));
        questions.add(new Question("What is the purpose of the 'this' keyword in Java?",
                new ArrayList<>(List.of("To refer to the current instance of the class", "To call a method of the superclass",
                        "To create a new instance of the class", "To refer to the parent class object")), 1));
        questions.add(new Question("Which of the following is NOT a primitive data type in Java?",
                new ArrayList<>(List.of("int", "float", "char", "string")), 4));
        questions.add(new Question("What is the purpose of the 'break' statement in Java?",
                new ArrayList<>(List.of("To end the execution of a loop or switch statement", "To skip the current iteration of a loop",
                        "To exit the entire program", "To continue to the next iteration of a loop")), 1));
        questions.add(new Question("How do you declare a constant in Java?",
                new ArrayList<>(List.of("const int MAX_VALUE = 100;", "final int MAX_VALUE = 100;", "static final int MAX_VALUE = 100;",
                        "int MAX_VALUE = 100;")), 3));
        questions.add(new Question("What is the role of the 'finally' block in exception handling?",
                new ArrayList<>(List.of("To catch and handle exceptions", "To specify the exception type", "To guarantee execution regardless of whether an exception occurs or not",
                        "To indicate the end of the try-catch block")), 3));

        Quiz quiz = new Quiz(questions);
        quiz.start();
    }
}
