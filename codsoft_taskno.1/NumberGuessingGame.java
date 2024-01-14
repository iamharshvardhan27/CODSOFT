import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1;  
        int maxRange = 100;   
        int attempts = 10;  
        int round = 1;  

        boolean playAgain = true;
        while (playAgain) {
            int randomNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            System.out.println("Round " + round + ": Guess the number between " + minRange + " and " + maxRange);
            int attempt = 1;

            while (attempt <= attempts) {
                System.out.print("Attempt " + attempt + ": Enter your guess: ");
                int userGuess = scanner.nextInt();

                if (userGuess == randomNumber) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    break;
                } else if (userGuess < randomNumber) {
                    System.out.println("Too low. Try again!");
                } else {
                    System.out.println("Too high. Try again!");
                }

                attempt++;
            }

            if (attempt > attempts) {
                System.out.println("Sorry, you've reached the maximum number of attempts. The number was: " + randomNumber);
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playChoice = scanner.next();
            if (!playChoice.equalsIgnoreCase("yes")) {
                playAgain = false;
            }
            round++;
        }
        System.out.println("Thank you for playing!");
        scanner.close();
    }
}
