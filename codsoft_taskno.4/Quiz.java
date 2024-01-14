import java.util.ArrayList;
import java.util.Scanner;

public class Quiz {
    private ArrayList<Question> questions;
    private int currentQuestionIndex;
    private int score;

    public Quiz(ArrayList<Question> questions) {
        this.questions = questions;
        this.currentQuestionIndex = 0;
        this.score = 0;
    }

    public void startQuiz() {
        if (questions.isEmpty()) {
            System.out.println("No questions available.");
            return;
        }

        displayNextQuestion();
    }

    private void displayNextQuestion() {
        if (currentQuestionIndex < questions.size()) {
            Question currentQuestion = questions.get(currentQuestionIndex);
            displayQuestion(currentQuestion);
        } else {
            endQuiz();
        }
    }

    private void displayQuestion(Question question) {
        System.out.println("Question: " + question.getQuestion());
        String[] options = question.getOptions();
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }

        int userChoice = getUserChoice();
        answerQuestion(userChoice);
    }

    private int getUserChoice() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your choice: ");
        return scanner.nextInt();
    }

    private void answerQuestion(int userChoice) {
        if (currentQuestionIndex < questions.size()) {
            Question currentQuestion = questions.get(currentQuestionIndex);
            int correctOptionIndex = currentQuestion.getCorrectOptionIndex();

            if (userChoice == correctOptionIndex + 1) {
                score++;
                System.out.println("Correct!");
            } else {
                System.out.println("Incorrect!");
            }

            currentQuestionIndex++;
            displayNextQuestion();
        } else {
            endQuiz();
        }
    }

    private void endQuiz() {
        System.out.println("Quiz ended!");
        System.out.println("Your score: " + score + "/" + questions.size());
    }
}
