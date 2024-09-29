import javax.swing.JOptionPane;

class Queue {
    private static int front, rear, capacity;
    private static int queue[];

    // Constructor to initialize the queue with a specific size
    Queue(int size) {
        front = rear = 0;
        capacity = size;
        queue = new int[capacity];
    }

    // Insert an element into the queue
    static void queueEnqueue(int item) {
        if (capacity == rear) { // check if the queue is full
            JOptionPane.showMessageDialog(null, "Queue is full");
        } else { // insert element at the rear
            queue[rear] = item;
            rear++;
        }
    }

    // Remove an element from the queue
    static void queueDequeue() {
        if (front == rear) { // check if queue is empty
            JOptionPane.showMessageDialog(null, "Queue is empty");
        } else {
            for (int i = 0; i < rear - 1; i++) {
                queue[i] = queue[i + 1];
            }
            rear--;
        }
    }

    // Display the queue elements
    static void queueDisplay() {
        if (front == rear) {
            JOptionPane.showMessageDialog(null, "Queue is Empty");
        } else {
            StringBuilder display = new StringBuilder("Queue elements: ");
            for (int i = front; i < rear; i++) {
                display.append(queue[i]).append(" ");
            }
            JOptionPane.showMessageDialog(null, display.toString());
        }
    }

    // Display the front element of the queue
    static void queueFront() {
        if (front == rear) {
            JOptionPane.showMessageDialog(null, "Queue is Empty");
        } else {
            JOptionPane.showMessageDialog(null, "Front Element of the queue: " + queue[front]);
        }
    }
}

public class NonCircQueue {
    public static void main(String[] args) {
        int size = Integer.parseInt(JOptionPane.showInputDialog("Enter queue capacity:"));
        Queue q = new Queue(size); // Create a queue of specified capacity

        while (true) {
            String[] options = {"Enqueue", "Dequeue", "Display Queue", "Display Front", "Exit"};
            int choice = JOptionPane.showOptionDialog(null, "Choose an operation", "Queue Operations",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch (choice) {
                case 0: // Enqueue
                    int value = Integer.parseInt(JOptionPane.showInputDialog("Enter value to enqueue:"));
                    q.queueEnqueue(value);
                    break;
                case 1: // Dequeue
                    q.queueDequeue();
                    JOptionPane.showMessageDialog(null, "Dequeue Succesfully");
                    break;
                case 2: // Display Queue
                    q.queueDisplay();
                    break;
                case 3: // Display Front
                    q.queueFront();
                    break;
                case 4: // Exit
                    JOptionPane.showMessageDialog(null, "Exiting the program");
                    System.exit(0);
                default:
                    break;
            }
        }
    }
}
