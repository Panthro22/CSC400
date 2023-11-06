package FinalProject;

public class Order {

  private CustomQueue<OrderInfo> orderQueue = new CustomQueue<>();

  public void addOrder(String lastName, int orderNumber, double totalCost) {
    OrderInfo orderInfo = new OrderInfo(lastName, orderNumber, totalCost);
    this.orderQueue.enqueue(orderInfo);
  }

  public void removeOrder() {
    if (!orderQueue.isEmpty()) {
      this.orderQueue.dequeue();
    } else {
      System.out.println("Order Queue is empty.");
    }
  }

  public void removeOrderByOrderNumber(int orderNumber) {
    if (!orderQueue.isEmpty()) {
      CustomQueue<OrderInfo> tempQueue = new CustomQueue<>();
      boolean orderFound = false;

      while (!orderQueue.isEmpty()) {
        OrderInfo orderInfo = orderQueue.dequeue();
        if (orderInfo.getOrderNumber() == orderNumber) {
          orderFound = true;
        } else {
          tempQueue.enqueue(orderInfo);
        }
      }

      if (orderFound) {
        orderQueue = tempQueue;
      } else {
        System.out.println("Order not found.");
      }
    } else {
      System.out.println("Order Queue is empty.");
    }
  }

  public CustomQueue<OrderInfo> getOrderQueue() {
    return this.orderQueue;
  }
}

class OrderInfo {

  private String lastName;
  private int orderNumber;
  private double totalCost;

  public OrderInfo(String lastName, int orderNumber, double totalCost) {
    this.lastName = lastName;
    this.orderNumber = orderNumber;
    this.totalCost = totalCost;
  }

  public String getLastName() {
    return lastName;
  }

  public int getOrderNumber() {
    return orderNumber;
  }

  public double getTotalCost() {
    return totalCost;
  }
}
