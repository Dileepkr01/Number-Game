import java.util.Random;

public class RandomNumberGenerator {
  public static int generateRandomNumber(int min, int max) {
    Random random = new Random();
    return random.nextInt(max - min + 1) + min;
  }

  public static void main(String[] args) {
    int randomNumber = generateRandomNumber(1, 100);
    System.out.println(randomNumber);
  }
}
