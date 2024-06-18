import java.util.Random;
import java.util.Scanner;

public class NumberGuessing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int score = 0;
        int roundsPlayed = 0;
        String playAgain = "yes";
        while (playAgain.equalsIgnoreCase("yes") || playAgain.equalsIgnoreCase("y")) {
            roundsPlayed++;
            if (playRound(random, sc)) {
                score++;
            }
            System.out.print("Do you want to play another round? (yes/no): ");
            playAgain = sc.nextLine();
        }
        System.out.println("Game over! You played " + roundsPlayed + " rounds and won " + score + " times.");
        sc.close();
    }

    private static boolean playRound(Random random, Scanner sc) {
        int numberToGuess = random.nextInt(100) + 1;
        int attemptsLeft = 10;

        while (attemptsLeft > 0) {
            System.out.print("Guess the number (1-100). Attempts left " + attemptsLeft + ": ");
            int guess = 0;
            try {
                guess = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter an integer.");
                continue;
            }

            if (guess < 1 || guess > 100) {
                System.out.println("Please enter a number between 1 and 100.");
                continue;
            }
            attemptsLeft--;
            if (guess < numberToGuess) {
                System.out.println("Too low!");
            } else if (guess > numberToGuess) {
                System.out.println("Too high!");
            } else {
                System.out.println("Congratulations! You guessed the correct number.");
                return true;
            }
        }

        System.out.println("Sorry, you've run out of attempts. The correct number was " + numberToGuess + ".");
        return false;
    }
}