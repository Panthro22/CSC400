package CTA5;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class JunitTestingOfCTA5 {

  @Test
  @DisplayName("Testing factorialRecursive")
  public void testFactorialRecursive() {
    assertEquals(1, RecursiveFactorials.factorialRecursive(0));
    assertEquals(1, RecursiveFactorials.factorialRecursive(1));
    assertEquals(24, RecursiveFactorials.factorialRecursive(4));
    assertEquals(120, RecursiveFactorials.factorialRecursive(5));
  }

  @Test
  @DisplayName("Testing factorialAlternative")
  public void testFactorialAlternative() {
    assertEquals(1, RecursiveFactorials.factorialAlternative(0));
    assertEquals(1, RecursiveFactorials.factorialAlternative(1));
    assertEquals(24, RecursiveFactorials.factorialAlternative(4));
    assertEquals(120, RecursiveFactorials.factorialAlternative(5));
  }

  @Test
  @DisplayName("Testing reverseArrayPortion")
  public void testReverseArrayPortion() {
    int[] arr = { 1, 2, 3, 4, 5 };
    ReversingArray.reverseArrayPortion(arr, 1, 3);
    assertArrayEquals(new int[] { 1, 4, 3, 2, 5 }, arr);

    int[] arr2 = { 9, 7, 5, 3, 1 };
    ReversingArray.reverseArrayPortion(arr2, 0, 4);
    assertArrayEquals(new int[] { 1, 3, 5, 7, 9 }, arr2);
    // numbers 1-21 in the array
    int[] arr3 = {
      1,
      2,
      3,
      4,
      5,
      6,
      7,
      8,
      9,
      10,
      11,
      12,
      13,
      14,
      15,
      16,
      17,
      18,
      19,
      20,
      21,
    };
    ReversingArray.reverseArrayPortion(arr3, 5, 15);
    assertArrayEquals(
      new int[] {
        1,
        2,
        3,
        4,
        5,
        16,
        15,
        14,
        13,
        12,
        11,
        10,
        9,
        8,
        7,
        6,
        17,
        18,
        19,
        20,
        21,
      },
      arr3
    );
  }
}
