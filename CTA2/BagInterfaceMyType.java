package CTA2;

public interface BagInterfaceMyType {
  void testAdd(MyType item); // add to the end of the bag
  void removeFirst(); // remove the first occurrence of the item
  void removeItem(MyType item); // remove specific item
  boolean contains(MyType item); // return true if the item is in the bag
  int getFrequencyOf(MyType item); // return the number of times the item is in the bag
  int getCurrentSize(); // return the number of items in the bag
  boolean isEmpty(); // return true if the bag is empty
  void clear(); // remove all items from the bag
  boolean isFull(); // return true if the bag is full
  MyType[] toArray(); // return a copy of the bag
  void displayBag(); // display the items in the bag
}
