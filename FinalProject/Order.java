package FinalProject;

import java.util.LinkedList;
import java.util.Queue;

public class Order {

  private Queue<OrderInfo> orderQueue = new LinkedList<>();

  public void addOrder(String lastName, String orderNumber, double totalCost) {
    OrderInfo orderInfo = new OrderInfo(lastName, orderNumber, totalCost);
    orderQueue.add(orderInfo);
  }

  public void removeOrder() {
    if (!orderQueue.isEmpty()) {
      orderQueue.poll();
    } else {
      System.out.println("Order Queue is empty.");
    }
  }

  public Queue<OrderInfo> getOrderQueue() {
    return orderQueue;
  }
}

class OrderInfo {

  private String lastName;
  private String orderNumber;
  private double totalCost;

  public OrderInfo(String lastName, String orderNumber, double totalCost) {
    this.lastName = lastName;
    this.orderNumber = orderNumber;
    this.totalCost = totalCost;
  }

  public String getLastName() {
    return lastName;
  }

  public String getOrderNumber() {
    return orderNumber;
  }

  public double getTotalCost() {
    return totalCost;
  }
}
