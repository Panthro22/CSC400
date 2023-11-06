package FinalProject;

import java.util.ArrayList;
import java.util.LinkedList;

// CustomQueue class to implement a queue using a linked list
public class CustomQueue<T> extends LinkedList<T> {

  private LinkedList<T> elements = new LinkedList<>();

  // add an element to the end of the queue
  public void enqueue(T element) {
    elements.addLast(element);
  }

  // remove an element from the front of the queue
  public T dequeue() {
    if (!isEmpty()) {
      return elements.removeFirst();
    } else {
      throw new IllegalStateException("Queue is empty.");
    }
  }

  // check if the queue is empty
  public boolean isEmpty() {
    return elements.isEmpty();
  }

  // get the size of the queue
  public int size() {
    return elements.size();
  }

  // get the element at the front of the queue without removing it
  public T peek() {
    if (!isEmpty()) {
      return elements.getFirst();
    } else {
      throw new IllegalStateException("Queue is empty.");
    }
  }

  // remove all elements from the queue
  public void clear() {
    elements.clear();
  }

  // remove an order from the queue by order number
  public void removeOrderByOrderNumber(int orderNumber) {
    if (!isEmpty()) {
      LinkedList<T> tempQueue = new LinkedList<>();
      boolean orderFound = false;

      while (!isEmpty()) {
        T element = dequeue();
        if (element instanceof OrderInfo) {
          OrderInfo orderInfo = (OrderInfo) element;
          if (orderInfo.getOrderNumber() == orderNumber) {
            orderFound = true;
          } else {
            tempQueue.addLast(element);
          }
        }
      }

      if (orderFound) {
        elements = tempQueue;
      } else {
        System.out.println("Order not found.");
      }
    } else {
      System.out.println("Order Queue is empty.");
    }
  }

  // get linked list returned as an array list
  public ArrayList<T> getArrayList() {
    ArrayList<T> arrayList = new ArrayList<>();
    for (T element : elements) {
      arrayList.add(element);
    }
    return arrayList;
  }
}
