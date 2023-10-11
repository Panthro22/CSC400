package ExamplesForDisscusions;

public class StackExample {

  private StringBuilder stringText;
  private Stack<String> undoStack;
  private Stack<String> redoStack;

  public StackExample() {
    stringText = new StringBuilder();
    undoStack = new Stack<>();
    redoStack = new Stack<>();
  }

  // Append text to the document
  public void addText(String newText) {
    undoStack.push(stringText.toString());
    stringText.append(newText);
    redoStack.clear(); // Clear redo stack when new text is added
  }

  // Undo the last operation
  public void undo() {
    if (!undoStack.isStackEmpty()) {
      redoStack.push(stringText.toString());
      stringText = new StringBuilder(undoStack.pop());
    }
  }

  // Redo the last undone operation
  public void redo() {
    if (!redoStack.isStackEmpty()) {
      undoStack.push(stringText.toString());
      stringText = new StringBuilder(redoStack.pop());
    }
  }

  // Get the current text
  public String getText() {
    return stringText.toString();
  }

  public static void main(String[] args) {
    StackExample textEditor = new StackExample();
    // Hello world! truer than pokemon starter
    textEditor.addText("Hello Everyone, ");
    textEditor.addText("\n Hope this examples helps with ADT Stack!");
    System.out.println(textEditor.getText());
    // output: Hello Everyone, \n Hope this examples helps with ADT Stack!

    textEditor.undo();
    System.out.println(textEditor.getText());
    // Output: Hello Everyone,

    textEditor.redo();
    System.out.println(textEditor.getText());
    // Output: Hello Everyone, \n Hope this examples helps with ADT Stack!
  }

  class Stack<T> {

    // the T is a generic type that can be any type of object.
    //The T could be swapped with String, or wrappers like Integer, Double, etc.
    // Since we will be using String which is a Object type we can use T as a String
    private Object[] textArray; // Array to store the stack elements. Building a very generic stack
    private int size; // Current stack size
    private static final int STARTING_CAPACITY = 10; // Default stack capacity

    public Stack() { // Construct a stack with the default capacity
      textArray = new Object[STARTING_CAPACITY];
      size = 0;
    }

    public void push(T item) { // Push a new item onto the stack
      if (size == textArray.length) {
        resizeArray();
      }
      textArray[size++] = item; // Add item to the stack and increment size
    }

    public T pop() { // Pop the top item from the stack
      if (isStackEmpty()) {
        throw new IllegalStateException("Stack is empty");
      }
      // wrap line 81 in a try catch block to catch the ClassCastException
      try {
        T item = (T) textArray[--size]; // Get the top item by using --size to get the last item in the array.
        textArray[size] = null; // Remove reference to the popped item
        return item;
      } catch (ClassCastException e) {
        System.out.println("ClassCastException: " + e.getMessage());
        System.out.println("Nsot type T?");
      }
      return null; // Top of the stack should absolutely be of type T if not return null
    }

    public boolean isStackEmpty() { // Test if the stack is empty
      return size == 0;
    }

    public void clear() { // Turn that stack upside down and pour out all the elements!
      for (int index = 0; index < size; index++) { // Null out Array elements
        textArray[index] = null;
      }
      size = 0; // Size now zero We empty the whole thing!
    }

    private void resizeArray() { // Resize the array to twice its current capacity as needed
      int newCapacity = (int) (textArray.length * 1.5); // Small chance of increase needed.
      Object[] newArray = new Object[newCapacity]; // Create a new array with 50% more capacity at a new memory location
      System.arraycopy(textArray, 0, newArray, 0, size); // Copy the contents from the old array to the new array
      textArray = newArray;
    }
  }
}
