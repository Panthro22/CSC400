package CTA4;

public class PostfixConverterTest {

  public static void main(String[] args) {
    //Test 1
    String infixExpression = "a/b*(c+(d-e))";
    System.out.println("Infix Expression: " + infixExpression);
    String postfixResult = PostfixConverter.convertToPostfix(infixExpression);
    System.out.println("Postfix Result: " + postfixResult);

    //Test 2
    String infixExpression2 = "f+g*h-(i/j^k-l*m+n)";
    System.out.println("Infix Expression 2: " + infixExpression2);
    String postfixResult2 = PostfixConverter.convertToPostfix(infixExpression2);
    System.out.println("Postfix Result 2: " + postfixResult2);

    //Test 3
    String infixExpression3 = "p*(q+r/s-(t*u^v*w+x-(y*z)^a))";
    System.out.println("Infix Expression 3: " + infixExpression3);
    String postfixResult3 = PostfixConverter.convertToPostfix(infixExpression3);
    System.out.println("Postfix Result 3: " + postfixResult3);

    //Test 4
    String infixExpression4 = "(a + b + c) * d*e/f";
    System.out.println("Infix Expression 4: " + infixExpression4);
    String postfixResult4 = PostfixConverter.convertToPostfix(infixExpression4);
    System.out.println("Postfix Result 4: " + postfixResult4);
  }
}
