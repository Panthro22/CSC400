package ExamplesForDisscusions;

public class Compliance {}

// public class Student {
//     public String name;
//     public int age;

//     public Student(String name, int age) {
//         this.name = name;
//         this.age = age;
//     }
// }

class Student {

  private String name;
  private int age;

  public Student(String name, int age) {
    this.name = name;
    this.age = age;
  }

  // Getter method for name
  public String getName() {
    return name;
  }

  // Setter method for name
  public void setName(String name) {
    this.name = name;
  }

  // Getter method for age
  public int getAge() {
    return age;
  }

  // Setter method for age
  public void setAge(int age) {
    this.age = age;
  }
}
