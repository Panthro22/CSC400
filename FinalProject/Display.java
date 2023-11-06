package FinalProject;

import java.util.ArrayList;
import java.util.Comparator;

// Display class to display orders sorted by name and order number
public class Display {

  // Two ArrayLists to store the orders sorted by name and order number
  private ArrayList<OrderInfo> orderListByName = new ArrayList<>();
  private ArrayList<OrderInfo> orderListByOrderNumber = new ArrayList<>();

  // Update the ArrayLists and sort them
  public void updateAndSortArrays(CustomQueue<OrderInfo> orderQueue) {
    // Clear the ArrayLists
    orderListByName.clear();
    orderListByOrderNumber.clear();

    orderListByName.addAll(orderQueue.getArrayList());
    orderListByOrderNumber.addAll(orderQueue.getArrayList());

    // Sort by name in descending order
    quickSort(
      orderListByName, // this is the array of OrderInfo objects
      0, // because the first index is 0
      orderListByName.size() - 1, // because the last index is size - 1 this the highest index
      Comparator.comparing(OrderInfo::getLastName).reversed() // this is the comparator
    );

    // Sort by order number in descending order
    quickSort(
      orderListByOrderNumber, // this is the array of OrderInfo objects
      0, // because the first index is 0
      orderListByOrderNumber.size() - 1, // because the last index is size - 1 this the highest index
      Comparator.comparing(OrderInfo::getOrderNumber).reversed() // this is the comparator
    );
  }

  // Display the orders sorted by name and order number
  public void displayOrders() {
    System.out.println("Orders sorted by name:");
    for (OrderInfo order : orderListByName) {
      System.out.println(
        "Last Name: " +
        order.getLastName() +
        ", Order Number: " +
        order.getOrderNumber() +
        ", Total Cost: " +
        order.getTotalCost()
      );
    }

    System.out.println("\nOrders sorted by order number:");
    for (OrderInfo order : orderListByOrderNumber) {
      System.out.println(
        "Last Name: " +
        order.getLastName() +
        ", Order Number: " +
        order.getOrderNumber() +
        ", Total Cost: " +
        order.getTotalCost()
      );
    }
  }

  // Quicksort method for sorting the array of OrderInfo objects
  public static void quickSort(
    ArrayList<OrderInfo> orderList,
    int low,
    int high,
    Comparator<OrderInfo> comparator
  ) {
    // Base case
    if (low < high) {
      // pivotIndex is partitioning index, arr[pi] is now at right place
      int pivotIndex = partition(orderList, low, high, comparator);
      // Recursively sort elements before partition and after partition
      quickSort(orderList, low, pivotIndex - 1, comparator);
      quickSort(orderList, pivotIndex + 1, high, comparator);
    }
  }

  // Partition method for quicksort
  public static int partition(
    ArrayList<OrderInfo> orderList,
    int low,
    int high,
    Comparator<OrderInfo> comparator
  ) {
    // OrderInfo pivot = orderList[high]; // pivot
    OrderInfo pivot = orderList.get(high);
    int indexSmall = low - 1; // int indexSmall is the index of the smaller element
    for (int arrayIndex = low; arrayIndex < high; arrayIndex++) { // int arrayIndex is being compared to the pivot
      if (comparator.compare(orderList.get(arrayIndex), pivot) <= 0) {
        indexSmall++;
        // swap orderList[indexSmall] and orderList[arrayIndex]
        OrderInfo temp = orderList.get(indexSmall);
        orderList.set(indexSmall, orderList.get(arrayIndex));
        orderList.set(arrayIndex, temp);
      }
    }
    // swap orderList[indexSmall + 1] and orderList[high] or pivot
    OrderInfo temp = orderList.get(indexSmall + 1);
    orderList.set(indexSmall + 1, orderList.get(high));
    orderList.set(high, temp);
    return indexSmall + 1;
  }
}
