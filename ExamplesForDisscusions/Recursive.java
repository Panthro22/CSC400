package ExamplesForDisscusions;

import java.io.File;
import java.util.Stack;

public class Recursive {

  public static int binarySearch(int[] arr, int target, int left, int right) {
    if (left <= right) { // Base case
      int mid = left + (right - left) / 2; // Find the middle index

      if (arr[mid] == target) { // Element found
        return mid;
      } else if (arr[mid] < target) { // Search the right half
        return binarySearch(arr, target, mid + 1, right);
      } else { // Search the left half
        return binarySearch(arr, target, left, mid - 1);
      }
    }
    return -1; // Element not found
  }

  public static void searchFiles(String directoryPath, String extension) {
    File directory = new File(directoryPath); // Get all files from a directory
    if (!directory.exists() || !directory.isDirectory()) { // Invalid directory
      System.out.println("Invalid directory path");
      return;
    }

    // Create a stack to simulate recursion
    Stack<File> stack = new Stack<>();
    stack.push(directory); // Push root directory to the stack

    while (!stack.isEmpty()) { // Loop until stack is empty
      File currentDir = stack.pop();
      File[] files = currentDir.listFiles();

      if (files != null) { // Loop through all files
        for (File file : files) {
          if (file.isDirectory()) { // Push sub-directories to the stack
            stack.push(file);
          } else if (file.getName().endsWith(extension)) { // Check the extension
            System.out.println("Found file: " + file.getAbsolutePath());
          }
        }
      }
    } // doing this way is more efficient than using recursion because it does not
    // have to keep track of the stack frame and the method call overhead. meaning that both the stack and the heap are not being used as much.
  }

  public static void main(String[] args) {
    int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }; //
    int target = 7;
    // Call the recursive method
    int result = binarySearch(arr, target, 0, arr.length - 1);

    if (result != -1) {
      System.out.println("Number found at index " + result);
    } else {
      System.out.println("Number not found");
    }
    // Set the directory path and extension
    String directory = "C:\\Users\\Paynt\\Documents\\CSUGobal\\Programming";
    String extension = "4.docx";
    // Call the iterative method
    searchFiles(directory, extension);
  }
}
