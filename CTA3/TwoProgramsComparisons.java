package CTA3;

public class TwoProgramsComparisons {

  public static void main(String[] args) {
    for (int n = 1; n <= 50; n++) {
      double a = 1000 * Math.pow(n, 2); // program a alogrithm
      double b = Math.pow(2, n); // program b alogrithm
      if (a < b) { // if a is less than b
        System.out.println(
          "Nth iteraton at " +
          n +
          "; A = " +
          (int) a +
          " is less than b: " +
          (int) b
        );
        break; // break out of the loop to show when a is finally less than b
      }
    }
  }
}
