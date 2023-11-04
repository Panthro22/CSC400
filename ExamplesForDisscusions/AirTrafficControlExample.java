package ExamplesForDisscusions;

import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicInteger;

class FlightRequest implements Comparable<FlightRequest> {

  private String flightName;
  private int priority;
  private int order; // To maintain the order of insertion
  private static AtomicInteger counter = new AtomicInteger(0);

  public FlightRequest(String flightName, int priority) {
    this.flightName = flightName;
    this.priority = priority;
    this.order = counter.incrementAndGet();
  }

  public String getFlightName() {
    return flightName;
  }

  public int getPriority() {
    return priority;
  }

  public int getOrder() {
    return order;
  }

  @Override
  public int compareTo(FlightRequest other) {
    if (this.priority != other.priority) {
      // Higher priority should be dequeued first
      return Integer.compare(this.priority, other.priority);
    } else {
      // For equal priorities, maintain the order of insertion
      return Integer.compare(this.order, other.order);
    }
  }
}

public class AirTrafficControlExample {

  public static void main(String[] args) {
    PriorityQueue<FlightRequest> priorityQueue = new PriorityQueue<>();

    // Enqueue flight requests with priorities with 10 flights and three priority levels
    priorityQueue.offer(new FlightRequest("Flight 1051", 3)); // Regular flight
    priorityQueue.offer(new FlightRequest("Flight 232", 1)); // Low fuel
    priorityQueue.offer(new FlightRequest("Flight 343", 3)); // Regular flight
    priorityQueue.offer(new FlightRequest("Flight 454", 2)); // Medical emergency
    priorityQueue.offer(new FlightRequest("Flight 565", 3)); // Regular flight
    priorityQueue.offer(new FlightRequest("Flight 787", 1)); // Low fuel
    priorityQueue.offer(new FlightRequest("Flight 667", 3)); // Regular flight
    priorityQueue.offer(new FlightRequest("Flight 877", 2)); // Medical emergency
    priorityQueue.offer(new FlightRequest("Flight 921", 3)); // Regular flight
    priorityQueue.offer(new FlightRequest("Flight 121", 2)); // Medical emergency

    // Process flight requests based on priority
    while (!priorityQueue.isEmpty()) {
      FlightRequest request = priorityQueue.poll();
      System.out.println(
        "Processing: " +
        request.getFlightName() +
        " (Priority: " +
        request.getPriority() +
        " Order: " +
        request.getOrder() +
        ")"
      );
    }
  }
}
