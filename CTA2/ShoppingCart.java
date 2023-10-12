package CTA2;

import java.util.Arrays;

public class ShoppingCart implements BagInterfaceMyType {

  private MyType[] myBag; // Creates an array bag
  private int numberOfItems; // number of items in the bag
  private final int DEFAULT_CAPACITY = 10; // default capacity of the bag

  // Fixed DEFAULT_CAPACITY to all uppercase as requested due to is being a constant

  public ShoppingCart() {
    myBag = new MyType[DEFAULT_CAPACITY];
    numberOfItems = 0;
  }

  public void testAdd(MyType item) { // adjusted name as requested
    if (isFull()) { // if the bag is full, print a message
      System.out.println("Bag is full");
    } else {
      myBag[numberOfItems] = item;
      numberOfItems++;
    }
  }

  public void removeFirst() {
    if (isEmpty()) { // if the bag is empty, print a message
      System.out.println("Bag is empty");
    } else { // shifts all items to the left
      System.out.println(
        "Removing first item: " +
        myBag[0].getName() +
        " with id: " +
        myBag[0].getId() +
        " and calories: " +
        myBag[0].getCalories() +
        " from the bag"
      );
      for (int i = 0; i < numberOfItems - 1; i++) {
        myBag[i] = myBag[i + 1];
      }
      myBag[numberOfItems - 1] = null;
      numberOfItems--;
    }
  }

  public void removeItem(MyType item) {
    if (isEmpty()) {
      System.out.println("Bag is empty");
    } else { // removes specific item from the bag
      for (int i = 0; i < numberOfItems; i++) {
        // if the item is found, shift items after it to the left
        if (myBag[i].getId() == item.getId()) {
          for (int j = i; j < numberOfItems - 1; j++) {
            myBag[j] = myBag[j + 1];
          }
          myBag[numberOfItems - 1] = null;
          numberOfItems--;
        }
      }
    }
  }

  public boolean contains(MyType item) { // return true if the item is in the bag
    for (int i = 0; i < numberOfItems; i++) {
      if (myBag[i].getId() == item.getId()) {
        return true;
      }
    }
    return false; // return false if the item is not in the bag
  }

  public int getFrequencyOf(MyType item) {
    int count = 0;
    for (int i = 0; i < numberOfItems; i++) {
      // count the number of times the item is in the bag
      if (myBag[i].getId() == item.getId()) {
        count++;
      }
    }
    return count;
  }

  public int getCurrentSize() { // return the number of items in the bag
    return numberOfItems;
  }

  public boolean isEmpty() { // return true if the bag is empty
    return numberOfItems == 0;
  }

  public void clear() { // remove all items from the bag
    for (int i = 0; i < numberOfItems; i++) {
      myBag[i] = null;
    }
    numberOfItems = 0;
  }

  public boolean isFull() { // return true if the bag is full
    return numberOfItems == DEFAULT_CAPACITY;
  }

  public MyType[] toArray() { // return a copy of the bag
    MyType[] copy = Arrays.copyOf(myBag, numberOfItems);
    return copy;
  }

  // adjusted name as requested
  public void displayBag() { // display the items in the bag
    for (int i = 0; i < numberOfItems; i++) {
      System.out.println(myBag[i]);
    }
  }

  public int getDEFAULT_CAPACITY() {
    return DEFAULT_CAPACITY;
  }
}
