package ExamplesForDisscusions;

import java.util.ArrayList;
import java.util.List;

class CustomerOrder {

  private int orderId;
  private String orderDate;

  public CustomerOrder(int orderId, String orderDate) {
    this.orderId = orderId;
    this.orderDate = orderDate;
  }

  public String getOrderDate() {
    return orderDate;
  }

  public int getOrderId() {
    return orderId;
  }
}

public class MergeSortEcommerceExample {

  // Merge Sort for sorting CustomerOrder objects by order date
  public static List<CustomerOrder> mergeSort(List<CustomerOrder> orders) {
    if (orders.size() <= 1) {
      return orders; // Already sorted
    }
    // Split the list of orders into two lists
    int mid = orders.size() / 2;
    List<CustomerOrder> left = orders.subList(0, mid);
    List<CustomerOrder> right = orders.subList(mid, orders.size());
    // Recursively sort the left and right lists
    left = mergeSort(left);
    right = mergeSort(right);

    return merge(left, right);
  }

  // Merge two sorted lists of CustomerOrder objects by order date
  private static List<CustomerOrder> merge(
    List<CustomerOrder> left,
    List<CustomerOrder> right
  ) {
    List<CustomerOrder> result = new ArrayList<>();
    int indexLeft = 0, indexRight = 0; // Indexes for left and right lists
    // Compare elements from left and right lists and add the smaller element to the result list
    while (indexLeft < left.size() && indexRight < right.size()) {
      CustomerOrder leftOrder = left.get(indexLeft);
      CustomerOrder rightOrder = right.get(indexRight);
      // Compare order dates of left and right orders
      if (leftOrder.getOrderDate().compareTo(rightOrder.getOrderDate()) <= 0) {
        result.add(leftOrder);
        indexLeft++;
      } else { // leftOrder.getOrderDate() > rightOrder.getOrderDate()
        result.add(rightOrder);
        indexRight++;
      }
    }
    // Add remaining elements from left list to result list
    result.addAll(left.subList(indexLeft, left.size()));
    result.addAll(right.subList(indexRight, right.size()));

    return result;
  }

  public static void main(String[] args) {
    // Create a list of customer orders
    List<CustomerOrder> orders = new ArrayList<>();
    orders.add(new CustomerOrder(1, "2023-10-25"));
    orders.add(new CustomerOrder(2, "2023-10-24"));
    orders.add(new CustomerOrder(3, "2023-10-26"));
    orders.add(new CustomerOrder(4, "2023-10-22"));
    orders.add(new CustomerOrder(5, "2023-10-23"));
    orders.add(new CustomerOrder(6, "2023-10-21"));
    orders.add(new CustomerOrder(7, "2023-10-20"));
    orders.add(new CustomerOrder(8, "2023-10-22"));
    orders.add(new CustomerOrder(9, "2023-10-23"));
    orders.add(new CustomerOrder(10, "2023-10-26"));

    // Sort the list of orders using Merge Sort
    List<CustomerOrder> sortedOrders = mergeSort(orders);

    // Display the sorted orders
    for (CustomerOrder order : sortedOrders) {
      System.out.println(
        "Order ID: " +
        order.getOrderId() +
        ", Order Date: " +
        order.getOrderDate()
      );
    }
  }
}
