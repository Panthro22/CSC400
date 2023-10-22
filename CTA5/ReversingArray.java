package CTA5;

public class ReversingArray {

  // Recursive method to display a portion of an array backward
  public static void reverseArrayPortion(
    int[] arr,
    int startIndex,
    int endIndex
  ) {
    // Base case is when startIndex is greater than or equal to endIndex
    // ending the recursion
    if (startIndex < endIndex) {
      // Swap elements at startIndex and endIndex
      int temp = arr[startIndex];
      arr[startIndex] = arr[endIndex];
      arr[endIndex] = temp;

      // Recursively reverse the remaining portion
      reverseArrayPortion(arr, startIndex + 1, endIndex - 1);
    }
  }
}
