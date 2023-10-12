package CTA4;

import java.util.Stack;

public class PostfixConverter {

  private static int precedence(char operator) {
    switch (operator) {
      case '^':
        return 3;
      case '*':
      case '/':
        return 2;
      case '+':
      case '-':
        return 1;
      default:
        return -1;
    }
  }

  public static String convertToPostfix(String infix) {
    Stack<Character> operatorStack = new Stack<>();
    StringBuilder postfixString = new StringBuilder();

    for (int index = 0; index < infix.length(); index++) {
      char nextCharacter = infix.charAt(index);

      if (Character.isWhitespace(nextCharacter)) continue;

      switch (nextCharacter) {
        case '+':
        case '-':
        case '*':
        case '/':
        case '^':
          while (
            !operatorStack.isEmpty() &&
            precedence(nextCharacter) <= precedence(operatorStack.peek())
          ) {
            char topOperator = operatorStack.pop();
            postfixString.append(topOperator);
          }
          operatorStack.push(nextCharacter);
          break;
        case '(':
          operatorStack.push(nextCharacter);
          break;
        case ')':
          while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
            char topOperator = operatorStack.pop();
            postfixString.append(topOperator);
          }
          if (!operatorStack.isEmpty() && operatorStack.peek() == '(') {
            operatorStack.pop(); // Pop the '('
          }
          break;
        default:
          if (Character.isLetter(nextCharacter)) {
            postfixString.append(nextCharacter);
          }
          break;
      }
    }

    while (!operatorStack.isEmpty()) {
      char topOperator = operatorStack.pop();
      postfixString.append(topOperator);
    }

    return postfixString.toString();
  }
}
