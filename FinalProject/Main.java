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
      System.out.println("4. Exit");
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
          String orderNumber = validateOrderNumber(scanner);
          System.out.print("Enter Total Cost: ");
          // validate total cost
          double totalCost = validateTotalCost(scanner);
          order.addOrder(lastName, orderNumber, totalCost);
          display.updateAndSortArrays(order.getOrderQueue());
          break;
        case 2:
          order.removeOrder();
          display.updateAndSortArrays(order.getOrderQueue());
          break;
        case 3:
          display.displayOrders();
          break;
        case 4:
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
      System.out.println("Invalid last name. Please enter a valid last name.");
      lastNameCheck = scanner.next();
    }
    return lastNameCheck;
  }

  // method to validate order number can contain letters, numbers and dashes
  private static String validateOrderNumber(Scanner scanner) {
    String orderNumberCheck = scanner.next();
    while (!orderNumberCheck.matches("[a-zA-Z0-9-]+")) {
      System.out.println(
        "Invalid order number. Please enter a valid order number."
      );
      orderNumberCheck = scanner.next();
    }
    return orderNumberCheck;
  }

  // method to validate total cost is a number and handle one decimal place of two decimal places
  private static double validateTotalCost(Scanner scanner) {
    double totalCostCheck = scanner.nextDouble();
    while (!String.valueOf(totalCostCheck).matches("[0-9]+.[0-9]{1,2}")) {
      System.out.println(
        "Invalid total cost. Please enter a valid total cost."
      );
      totalCostCheck = scanner.nextDouble();
    }
    return totalCostCheck;
  }
}
