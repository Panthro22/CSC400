package CTA2;

public class MyType {
  private int id;
  private String name;
  private int calories;

  public MyType(int id, String name, int calories) {
      this.id = id;
      this.name = name;
      this.calories = calories;
  }

  public int getId() {
        return id;
  }

  public String getName() {
      return name;
  }

  public int getCalories() {
      return calories;
  }

  public void setStock(int calories) {
      this.calories = calories;
  }

  @Override
  public String toString() {
      return "Item{" +
              "id=" + id +
              ", name='" + name + '\'' +
              ", calories=" + calories +
              '}';
  }
}
