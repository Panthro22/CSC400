package CTA6;

// Pg 458 Excersie # 11
// Devise an algorithm that determines whether an array is sorted in ascending order. Write a
// Java method that implements your algorithm. you can use your method to test whether a sort method has
// executed correctly.
public class ArraySortAscendedChecker {

  // Big O: O(n) Since we have to iterate through the entire array to check if it is sorted.
  // Thought about comparing left side to right side working towards the middle for a big O of O(n/2) but
  // it would still be unable to garuntee that the array is 100% sorted.
  // Recursive method would simply increase the space complexity and not improve the time complexity enough to be worth it.
  public static boolean isSortedAscending(int[] arr) {
    if (arr.length == 0 || arr.length == 1) {
      // An empty array or an array with a single element is sorted.
      return true;
    }
    for (int index = 0; index < arr.length - 1; index++) {
      if (arr[index] > arr[index + 1]) {
        // If the current element is greater than the next element, the array is not sorted.
        return false;
      }
    }
    // When no elements are out of order, the array is sorted.
    return true;
  }
}
