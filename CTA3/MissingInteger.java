package CTA3;

public class MissingInteger {

  public static void main(String[] args) {
    int[] arr = { 4, 2, 9, 8, 3, 6, 7, 1, 5 };
    int missing = findMissingInteger(arr);
    System.out.println(
      missing > -1 ? "Missing integer: " + missing : "No missing integer found" // Prints out the correct message using a ternary operator
    );
  }

  public static int findMissingInteger(int[] arr) {
    for (int i = 1; i < arr.length + 2; i++) { // O(n)
      boolean found = false;
      for (int j = 0; j < arr.length; j++) { // O(n)
        if (arr[j] == i) { // O(1) because it is a constant time operation
          found = true;
          break;
        }
      }
      if (!found) {
        return i; //
      }
    } // O(n) * O(n) = O(n^2)
    return -1;
  }
}
