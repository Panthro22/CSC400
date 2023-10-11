package CTA2;
import java.util.Scanner;

public class BagDemo {
  ShoppingCart shoppingCart = new ShoppingCart();
  boolean userContinue = true;
  MyType[] items;
  
  public static void main(String[] args) {
    Scanner scnr = new Scanner(System.in);
    BagDemo app = new BagDemo();
    //test add of items into the bag
    for (int i = 0; i < app.shoppingCart.getDefault_Capacity() -1; i++) {// add 9 items to the shopping cart
      app.shoppingCart.add(generateMyTypeForCart());
    }
    //display the shopping cart after generating 9 items
    while (app.userContinue){
      System.out.println();
      System.out.println("This is the shopping cart");
      app.shoppingCart.display();
      System.out.println("End of shopping cart");
      System.out.println();
      displayMenu();
      String userChoice = validateUserMenuChoice(scnr);
      menuChoice(userChoice, scnr, app);
      
      
      }
    scnr.close(); // close the scanner
    }

  private static void menuChoice(String userChoice, Scanner scnr, BagDemo app) {
    // switch to allow user to test each method
    int id;
    String name;
    int calories;
    MyType item;
      switch(userChoice){
        case "1":// add an item to the cart
          System.out.println("Enter the id of the item you want to add");
          id = validateUserInputOnlyNumbers(scnr);
          System.out.println("Enter the name of the item you want to add");
          name = scnr.nextLine();
          System.out.println("Enter the calories of the item you want to add");
          calories = validateUserInputOnlyNumbers(scnr);
          item = new MyType(id, name, calories);
          app.shoppingCart.add(item);
          break;
        case "2":// remove first item from the cart
          app.shoppingCart.removeFirst();
          break;
        case "3":// remove an item from the cart
          System.out.println("Enter the id of the item you want to remove");
          id = validateUserInputOnlyNumbers(scnr);
          System.out.println("Enter the name of the item you want to remove");
          name = scnr.nextLine();
          System.out.println("Enter the calories of the item you want to remove");
          calories = validateUserInputOnlyNumbers(scnr);
          item = new MyType(id, name, calories);
          app.shoppingCart.removeItem(item);
          break;
        
        case "4": // check if an item is in the cart
          System.out.println("Enter the id of the item you want to check");
          id = validateUserInputOnlyNumbers(scnr);
          System.out.println("Enter the name of the item you want to check");
          name = scnr.nextLine();
          System.out.println("Enter the calories of the item you want to check");
          calories = validateUserInputOnlyNumbers(scnr);
          item = new MyType(id, name, calories);
          System.out.println("This item is in the cart: " + (app.shoppingCart.contains(item) ? "Yes" : "No"));
          break;
        case "5": // get the frequency of an item in the cart
          System.out.println("Enter the id of the item you want to check");
          id = validateUserInputOnlyNumbers(scnr);
          name = null;
          calories = 0;
          item = new MyType(id, name, calories);
          System.out.println("There are items with this Id " + id + " in the cart: "+ app.shoppingCart.getFrequencyOf(item));
          break;
        case "6": // get the number of items in the cart
          System.out.println("There are Currently: " + app.shoppingCart.getCurrentSize() + " items in the cart");
          break;
        case "7": // check if the cart is empty
          System.out.println("Is the cart empty?\nThe Cart is indeed " + ( app.shoppingCart.isEmpty() ? "empty!" : "not empty."));
          break;
        case "8": // clear the cart
          System.out.println("Oh no a fellow shopper was sprinting through the store and knocked over your cart!");  
          app.shoppingCart.clear();
          break;
        case "9": // Check if cart is full
          System.out.println("The Cart is full?\nThe Cart is " + (app.shoppingCart.isFull() ? "full!" : "not full."));
          break;
        case "10": // toArray
          MyType[] items = app.shoppingCart.toArray();
          System.out.println(app.shoppingCart + "This is the original cart");
          System.out.println(items + "This is the copy of the cart");
          System.out.println("The copy items in the cart are:");
          for (int i = 0; i < items.length; i++) {
            System.out.println(items[i]);
          }
          System.out.println("end of copy items");
          break;
        case "11": // exit
          app.userContinue = false;
          break;
      }
  }
  // display the menu
  private static void displayMenu() {
    System.out.println("1. Add an item to the cart");
    System.out.println("2. Remove first item from the cart");
    System.out.println("3. Remove an item from the cart");
    System.out.println("4. Check if an item is in the cart");
    System.out.println("5. Get the frequency of an item in the cart");
    System.out.println("6. Get the number of items in the cart");
    System.out.println("7. Check if the cart is empty");
    System.out.println("8. Clear the cart");
    System.out.println("9. Check if cart is full");
    System.out.println("10. ToArray");
    System.out.println("11. Exit");
    System.out.println("Enter your choice");
  }

  // generate a random MyType object
  public static MyType generateMyTypeForCart(){
    int id = (int) (Math.random() * 12);
    String name = "Product" + (int)(Math.random()*24);
    int stock = (int) (Math.random() * 60);
    return new MyType(id, name, stock);
  }
  // validate user input for the menu
  public static String validateUserMenuChoice(Scanner scnr2){
    String userInput = scnr2.nextLine();
    // validate user input
    while (!userInput.equals("1") && !userInput.equals("2") && !userInput.equals("3") && !userInput.equals("4") && !userInput.equals("5") && !userInput.equals("6") && !userInput.equals("7") && !userInput.equals("8") && !userInput.equals("9") && !userInput.equals("10") && !userInput.equals("11")){
        System.out.println("Invalid input. Please enter a number between 1 and 10");
        userInput = scnr2.nextLine();
    }
    return userInput;
    
  }
  // validate user input for only int numbers
  public static int validateUserInputOnlyNumbers(Scanner scnr3) {
    int userInput;

    while (true) {
        if (scnr3.hasNextInt()) {
            userInput = scnr3.nextInt();
            scnr3.nextLine(); // Consume the newline character
            break; // Exit the loop if valid input is provided
        } else {
            System.out.println("Invalid input. Please enter a number");
            scnr3.nextLine(); // Consume the invalid input line
        }
    }

    return userInput;
 }

}
