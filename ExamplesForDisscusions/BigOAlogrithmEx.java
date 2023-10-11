package ExamplesForDisscusions;

public class BigOAlogrithmEx {

  // Binary search algorithm which is a logarithmic time complexity
  public static int binarySearch(int[] arr, int target) {
    int left = 0;
    int right = arr.length - 1;

    while (left <= right) {
      int mid = left + (right - left) / 2;

      if (arr[mid] == target) {
        return mid; // Element found
      } else if (arr[mid] < target) {
        left = mid + 1; // Search in the right half
      } else {
        right = mid - 1; // Search in the left half
      }
    }
    return -1; // Element not found
  }

  // Linear search algorithm
  public static int linearSearch(int[] arr, int target) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == target) {
        return i; // Element found at index i
      }
    }
    return -1; // Element not found
  }

  // Bubble sort algorithm
  public static int[] bubbleSort(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n - 1; i++) {
      for (int j = 0; j < n - i - 1; j++) {
        if (arr[j] > arr[j + 1]) {
          // Swap arr[j] and arr[j + 1]
          int temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
        }
      }
    }
    return arr;
  }

  public static int[] generateReverseSortedArray(int size) {
    int[] arr = new int[size];

    // Initialize the last element (at index size - 1)
    arr[size - 1] = 1;

    // Generate reverse sorted values for the remaining elements
    for (int i = size - 2; i >= 0; i--) {
      arr[i] = arr[i + 1] + 1;
    }

    return arr;
  }

  public static void main(String[] args) {
    int[] reverseSortedArray = generateReverseSortedArray(1000000);

    int[] bubbleArray = reverseSortedArray;

    Long startTime = System.currentTimeMillis();
    int[] sortedArray = bubbleSort(bubbleArray);
    Long endTime = System.currentTimeMillis();

    System.out.println("Bubble Sorted array ");

    Long executionTime = endTime - startTime;
    System.out.println("Execution time: " + executionTime + " milliseconds");

    int target = 0; // for worst case scenario logaritmic time complexity and linear time complexity

    startTime = System.currentTimeMillis();
    int result = binarySearch(sortedArray, target);
    endTime = System.currentTimeMillis();
    System.out.println("Binary Sorted array ");
    if (result != -1) {
      System.out.println("Element found at index: " + result);
    } else {
      System.out.println("Element not found.");
    }
    executionTime = endTime - startTime;
    System.out.println("Execution time: " + executionTime + " milliseconds");

    System.out.println("Linear Sorted array ");
    startTime = System.currentTimeMillis();
    result = linearSearch(sortedArray, target);
    endTime = System.currentTimeMillis();

    if (result != -1) {
      System.out.println("Element found at index: " + result);
    } else {
      System.out.println("Element not found.");
    }

    executionTime = endTime - startTime;
    System.out.println("Execution time: " + executionTime + " milliseconds");
  }
}
