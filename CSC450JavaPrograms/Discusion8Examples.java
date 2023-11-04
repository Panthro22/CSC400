package CSC450JavaPrograms;

import java.util.Arrays;
import java.util.regex.Pattern;

public class Discusion8Examples {}

class InsufficientFundsException extends Exception {

  public InsufficientFundsException(String message) {
    super(message);
  }
}

class BankAccount {

  private double balance;

  public BankAccount(double initialBalance) {
    this.balance = initialBalance;
  }

  public void withdraw(double amount) throws InsufficientFundsException {
    if (amount <= 0) {
      throw new IllegalArgumentException(
        "Withdrawal amount must be greater than zero."
      );
    }

    if (amount > balance) {
      throw new InsufficientFundsException(
        "Insufficient funds to withdraw $" + amount
      );
    }

    balance -= amount;
  }
}

class InputValidator {

  public static boolean isValidEmail(String email) {
    String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
    return Pattern.matches(emailRegex, email);
  }

  public static boolean isValidPassword(String password) {
    // Implement password validation logic
    return password.length() >= 8;
  }
}

class UserService {

  public void registerUser(String email, String password) {
    if (!InputValidator.isValidEmail(email)) {
      throw new IllegalArgumentException("Invalid email address.");
    }
    if (!InputValidator.isValidPassword(password)) {
      throw new IllegalArgumentException(
        "Password must be at least 8 characters long."
      );
    }
    // Register the user
  }
}

// bad example for sorting an array
class InefficientSortingExample {

  public static void main(String[] args) {
    int[] numbers = { 5, 2, 8, 1, 9 };
    // Inefficient sorting using bubble sort O(n^2)
    for (int i = 0; i < numbers.length - 1; i++) {
      for (int j = 0; j < numbers.length - i - 1; j++) {
        if (numbers[j] > numbers[j + 1]) {
          int temp = numbers[j];
          numbers[j] = numbers[j + 1];
          numbers[j + 1] = temp;
        }
      }
    }
  }
}

// better example for sorting an array using the built in sort method
class EfficientSortingExample {

  public static void main(String[] args) {
    int[] numbers = { 5, 2, 8, 1, 9 };
    // Efficient sorting using quicksort
    Arrays.sort(numbers); // O(n log n)
  }
}

class ObjectCreationExample {

  public static void main(String[] args) {
    // Excessive object creation
    for (int i = 0; i < 1000; i++) {
      String result = "Result: " + i; // Creates a new String object each iteration
    }
  }
}
