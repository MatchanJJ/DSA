import javax.swing.JOptionPane;

class Node {
    int data; // integer data
    Node next; // pointer to the next node
}

class Stack {
    private Node top;

    // Constructor
    public Stack() {
        this.top = null;
    }

    // Utility function to add an element `x` to the stack
    public void push(int x) {
        Node node = new Node(); // allocate a new node in a heap

        // check if stack (heap) is full. Then inserting an element would lead to stack overflow
        if (node == null) {
            JOptionPane.showMessageDialog(null, "Heap Overflow", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        node.data = x; // set data in the allocated node
        node.next = top; // set the `.next` pointer of the new node to point to the current top node
        top = node; // update top pointer

        JOptionPane.showMessageDialog(null, "Inserted: " + x, "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    // Utility function to check if the stack is empty or not
    public boolean isEmpty() {
        return top == null;
    }

    // Utility function to return the top element of the stack
    public int peek() {
        if (!isEmpty()) {
            return top.data;
        } else {
            JOptionPane.showMessageDialog(null, "The stack is empty", "Error", JOptionPane.WARNING_MESSAGE);
            return -1;
        }
    }

    // Utility function to pop a top element from the stack
    public void pop() {
        if (top == null) {
            JOptionPane.showMessageDialog(null, "Stack Underflow", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int removed = top.data;
        top = top.next; // update the top pointer to point to the next node
        JOptionPane.showMessageDialog(null, "Removed: " + removed, "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    // Utility function to display all elements in the stack
    public String display() {
        if (isEmpty()) {
            return "Stack is empty";
        }

        StringBuilder stackElements = new StringBuilder("Stack Elements: ");
        Node temp = top;
        while (temp != null) {
            stackElements.append(temp.data).append(" ");
            temp = temp.next;
        }

        return stackElements.toString();
    }
}

public class StackLinkedList {
    public static void main(String[] args) {
        Stack stack = new Stack();
        String[] options = { "Push", "Pop", "Peek", "Check Empty", "Display", "Exit" };
        int choice;

        do {

            choice = JOptionPane.showOptionDialog(null, "Choose an option", "Stack Operations",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch (choice) {
                case 0: // Push
                    try {
                        int value = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter an integer to push:"));
                        stack.push(value);
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Invalid input! Please enter an integer.", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                case 1: // Pop
                    stack.pop();
                    break;
                case 2: // Peek
                    int topElement = stack.peek();
                    if (topElement != -1) {
                        JOptionPane.showMessageDialog(null, "Top element: " + topElement, "Peek", JOptionPane.INFORMATION_MESSAGE);
                    }
                    break;
                case 3: // Check if Empty
                    boolean isEmpty = stack.isEmpty();
                    String message = isEmpty ? "The stack is empty." : "The stack is not empty.";
                    JOptionPane.showMessageDialog(null, message, "Empty Status", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 4: // Display Stack Elements
                    JOptionPane.showMessageDialog(null, stack.display(), "Stack Elements", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 5: // Exit
                    JOptionPane.showMessageDialog(null, "Exiting the program.", "Exit", JOptionPane.INFORMATION_MESSAGE);
                    break;
                default:
                    break;
            }
        } while (choice != 5); // Exit the loop when the user chooses "Exit"
    }
}
