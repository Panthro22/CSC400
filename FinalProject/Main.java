package FinalProject;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Order order = new Order();
    Display display = new Display();

    while (true) {
      System.out.println("\nMenu:");
      System.out.println("1. Add an Order");
      System.out.println("2. Remove an Order");
      System.out.println("3. Display Orders");
      System.out.println("4. Remove order by order number");
      System.out.println("5. Exit");
      System.out.print("Enter your choice: ");
      int choice = scanner.nextInt();

      switch (choice) {
        // case 1: also needs to use the validation methods
        case 1:
          System.out.print("Enter Last Name: ");
          // validate last name
          String lastName = validateLastName(scanner);
          System.out.print("Enter Order Number: ");
          // validate order number
          int orderNumber = validateOrderNumber(scanner);
          System.out.print("Enter Total Cost: ");
          // validate total cost
          double totalCost = validateTotalCost(scanner);
          order.addOrder(lastName, orderNumber, totalCost);
          display.updateAndSortArrays(order.getOrderQueue());
          display.displayOrders();
          break;
        case 2:
          order.removeOrder();
          display.updateAndSortArrays(order.getOrderQueue());
          display.displayOrders();
          break;
        case 3:
          display.displayOrders();
          break;
        case 4:
          System.out.print("Enter Order Number: ");
          int orderNumberToRemove = validateOrderNumber(scanner);
          order.removeOrderByOrderNumber(orderNumberToRemove);
          display.updateAndSortArrays(order.getOrderQueue());
          break;
        case 5:
          System.out.println("Exiting the program.");
          scanner.close();
          System.exit(0);
          break;
        default:
          System.out.println("Invalid choice. Please enter a valid option.");
      }
    }
  }

  // methods to validate Last Name, Order Number and Total Cost
  // method to validate last name can contain only letters
  private static String validateLastName(Scanner scanner) {
    String lastNameCheck = scanner.next();
    while (!lastNameCheck.matches("[a-zA-Z]+")) {
      System.out.println(
        "Invalid last name. Please enter a valid last name. Only letters are allowed."
      );
      lastNameCheck = scanner.next();
    }
    return lastNameCheck;
  }

  // method to validate order number which can contain letters, numbers and dashes
  private static int validateOrderNumber(Scanner scanner) {
    int orderNumberCheck = scanner.nextInt();
    while (!String.valueOf(orderNumberCheck).matches("[0-9]+")) {
      System.out.println(
        "Invalid order number. Please enter a valid order number using only numbers."
      );
      orderNumberCheck = scanner.nextInt();
    }
    return orderNumberCheck;
  }

  // method to validate total cost is a number and handle one decimal place of two decimal places
  private static double validateTotalCost(Scanner scanner) {
    double totalCostCheck = scanner.nextDouble();
    while (!String.valueOf(totalCostCheck).matches("[0-9]+.[0-9]{1,2}")) {
      System.out.println(
        "Invalid total cost. Please enter a valid total cost. only two decimal places are allowed."
      );
      totalCostCheck = scanner.nextDouble();
    }
    return totalCostCheck;
  }
}
