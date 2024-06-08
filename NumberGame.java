import java.util.Random;
import java.util.Scanner;

public class Main{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int maxAttempts = 5;
        int totalRounds = 3;
        int score = 0;

        for(int round = 1; round <= totalRounds; round++)
        {
            int numberToGuess = random.nextInt(100)+1;
            boolean hasGuessedCorrectly = false;
            System.out.println("Round " +round+ " of " +totalRounds );
            System.out.println("I have selected a number between 1 and 100. Try to guess it! ");
            for(int attempt = 1; attempt <= maxAttempts; attempt++)
            {
                System.out.println("Attempt " +attempt+ " : Enter your guess : ");
                int userGuess = scanner.nextInt();
                if(userGuess == numberToGuess)
                {
                    System.out.println("Congratulations! You've guessed the number correctly. ");
                    score++;
                    hasGuessedCorrectly = true;
                    break;
                }
                else if (userGuess < numberToGuess)
                {
                    System.out.println("Your guess is too low. ");
                }
                else{
                    System.out.println("Your guess is too high. ");
                }
            }
            if(!hasGuessedCorrectly)
            {
                System.out.println("You've used all attempts. The correct number was: " +numberToGuess);
            }
            System.out.println("Your current score is: " +score);
            System.out.println();

        }
        System.out.println("Game over! Your final score is: " +score+ " out of " +totalRounds);
        scanner.close();
        }
}
