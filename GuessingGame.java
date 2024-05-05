import java.util.Scanner;

public class GuessingGame {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int randomNumber = generateRandomNumber(1, 100);
    int attempts = 0;
    int maxAttempts = 6;

    while (attempts < maxAttempts) {
      System.out.println("Guess a number between 1 and 100 (attempt " + (attempts + 1) + "/" + maxAttempts + "):");
      int userGuess = scanner.nextInt();
      attempts++;

      if (userGuess == randomNumber) {
        System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
        break;
      } else if (userGuess > randomNumber) {
        System.out.println("Your guess is too high! Try again.");
      } else {
        System.out.println("Your guess is too low! Try again.");
      }
    }

    if (attempts >= maxAttempts) {
      System.out.println("You didn't guess the number in " + maxAttempts + " attempts. The number was " + randomNumber + ".");
    }
  }

  public static int generateRandomNumber(int min, int max) {
    return (int) (Math.random() * (max - min + 1)) + min;
  }
}

