import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Question> questions = new ArrayList<>();
        questions.add(new Question("What is the capital of France?", new String[]{"London", "Paris", "Rome", "Berlin"}, 1));
        questions.add(new Question("What is 2 + 2?", new String[]{"3", "4", "5", "6"}, 1));
        questions.add(new Question("Which programming language is known for its 'Write Once, Run Anywhere' principle?", new String[]{"Java", "C++", "Python", "JavaScript"}, 0));
        questions.add(new Question("What is the largest planet in our solar system?", new String[]{"Mars", "Jupiter", "Saturn", "Earth"}, 1));
        questions.add(new Question("In which year did the World War II end?", new String[]{"1939", "1945", "1950", "1960"}, 1));
        questions.add(new Question("Who is the author of 'Romeo and Juliet'?", new String[]{"William Shakespeare", "Charles Dickens", "Jane Austen", "Mark Twain"}, 0));

        Quiz quiz = new Quiz(questions);
        quiz.startQuiz();
    }
}
