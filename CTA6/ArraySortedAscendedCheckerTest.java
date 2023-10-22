package CTA6;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class ArraySortedAscendedCheckerTest {

  @Test
  @DisplayName("Test sorted array")
  public void testSortedArray() {
    int[] sortedArray = { 1, 2, 3, 4, 5 };
    assertTrue(ArraySortAscendedChecker.isSortedAscending(sortedArray));
  }

  @Test
  @DisplayName("Test unsorted array")
  public void testUnsortedArray() {
    int[] unsortedArray = { 5, 3, 1, 4, 2 };
    assertFalse(ArraySortAscendedChecker.isSortedAscending(unsortedArray));
  }

  @Test
  @DisplayName("Test null array")
  public void testEmptyArray() {
    int[] emptyArray = {};
    assertTrue(ArraySortAscendedChecker.isSortedAscending(emptyArray));
  }

  @Test
  @DisplayName("Test single element array")
  public void testSingleElementArray() {
    int[] singleElementArray = { 42 };
    assertTrue(ArraySortAscendedChecker.isSortedAscending(singleElementArray));
  }
}
