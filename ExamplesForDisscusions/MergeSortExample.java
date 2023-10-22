package ExamplesForDisscusions;

import java.util.Arrays;
import java.util.Comparator;

// Object Student with name and gpa
class Student {

  String name;
  double gpa;

  public Student(String name, double gpa) {
    this.name = name;
    this.gpa = gpa;
  }

  @Override
  // Override toString() to print a more readable Student object
  public String toString() {
    return name + ": " + gpa;
  }
}

public class MergeSortExample {

  public static void main(String[] args) {
    Student[] students = {
      new Student("Alice", 3.7),
      new Student("Bob", 3.5),
      new Student("Charlie", 4.0),
      new Student("David", 3.8),
      new Student("Eva", 3.5),
      new Student("Frank", 3.9),
      new Student("George", 3.7),
      new Student("Helen", 3.8),
      new Student("Ivan", 3.6),
      new Student("John", 3.9),
      new Student("Kevin", 3.8),
      new Student("Linda", 3.7),
      new Student("Mary", 3.6),
      new Student("Nancy", 2.5),
      // Add more student records here...
    };
    // Print unsorted students
    System.out.println("Unsorted Students:");
    Arrays.stream(students).forEach(System.out::println); //
    Comparator<Student> comparator = (student1, student2) -> {
      // Compare GPA, higher GPA first
      int gpaComparison = Double.compare(student2.gpa, student1.gpa);

      if (gpaComparison != 0) {
        // If GPAs are different, return the GPA comparison result
        return gpaComparison;
      } else {
        // If GPAs are equal, sort by name in ascending order
        return student1.name.compareTo(student2.name);
      }
    };
    // Sort students by GPA and then by name if GPAs are equal
    mergeSort(students, comparator);
    // Print sorted students
    System.out.println("\nSorted Students by GPA:");
    Arrays.stream(students).forEach(System.out::println);
  }

  // Merge sort algorithm for Student objects with Comparator
  public static void mergeSort(Student[] arr, Comparator<Student> comparator) {
    if (arr.length > 1) { // Base case
      int mid = arr.length / 2;
      Student[] leftArr = Arrays.copyOfRange(arr, 0, mid); // Left sub-array
      Student[] rightArr = Arrays.copyOfRange(arr, mid, arr.length); // Right sub-array

      mergeSort(leftArr, comparator); // Recursive call for left sub-array
      mergeSort(rightArr, comparator); // Recursive call for right sub-array

      int i = 0, j = 0, k = 0;
      // Merge leftArr and rightArr into arr
      while (i < leftArr.length && j < rightArr.length) {
        if (comparator.compare(leftArr[i], rightArr[j]) <= 0) {
          arr[k++] = leftArr[i++];
        } else { // leftArr[i] > rightArr[j]
          arr[k++] = rightArr[j++];
        }
      }
      // Copy remaining elements from leftArr
      while (i < leftArr.length) {
        arr[k++] = leftArr[i++];
      }
      // Copy remaining elements from rightArr
      while (j < rightArr.length) {
        arr[k++] = rightArr[j++];
      }
    }
  }
}
