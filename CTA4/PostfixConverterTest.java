package CTA4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PostfixConverterTest {

  @Test
  public void testConversion1() {
    String infixExpression = "a/b*(c+(d-e))";
    String expectedPostfixResult = "ab/cde-+*";
    String postfixResult = PostfixConverter.convertToPostfix(infixExpression);
    assertEquals(expectedPostfixResult, postfixResult);
  }

  @Test
  public void testConversion2() {
    String infixExpression = "f+g*h-(i/j^k-l*m+n)";
    String expectedPostfixResult = "fgh*+ijk^/lm*-n+-";
    String postfixResult = PostfixConverter.convertToPostfix(infixExpression);
    assertEquals(expectedPostfixResult, postfixResult);
  }

  @Test
  public void testConversion3() {
    String infixExpression = "p*(q+r/s-(t*u^v*w+x-(y*z)^a))";
    String expectedPostfixResult = "pqrs/+tuv^*w*x+yz*a^--*";
    String postfixResult = PostfixConverter.convertToPostfix(infixExpression);
    assertEquals(expectedPostfixResult, postfixResult);
  }

  @Test
  public void testConversion4() {
    String infixExpression = "(a + b + c) * d*e/f";
    String expectedPostfixResult = "ab+c+d*e*f/";
    String postfixResult = PostfixConverter.convertToPostfix(infixExpression);
    assertEquals(expectedPostfixResult, postfixResult);
  }
}
