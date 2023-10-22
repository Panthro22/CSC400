package CTA5;

public class RecursiveFactorials {

  // Recursive method to calculate factorial with base case of 0
  public static int factorialRecursive(int n) {
    if (n == 0) { // Base case is when n is 0
      return 1;
    } else {
      return n * factorialRecursive(n - 1); // Recursive call till base case is reached
    }
  }

  // Factorial recursive method base case of 1
  public static int factorialAlternative(int n) {
    if (n <= 1) { // The difference is that this method has a base case of 1 instead of 0
      return 1;
    } else {
      return n * factorialAlternative(n - 1);
    }
  }
  // Even though the base case is different, the result is the same
}
