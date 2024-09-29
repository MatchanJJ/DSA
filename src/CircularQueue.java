import javax.swing.*;

class CircularQueue {
    private int size, front, rear;
    private int[] queue;

    CircularQueue(int size) {
        this.size = size;
        this.front = this.rear = -1;
        queue = new int[size];
    }

    // Method to insert a new element in the queue
    public void enQueue(int data) {
        // Queue is full condition
        if ((front == 0 && rear == size - 1) || (rear == (front - 1) % (size - 1))) {
            JOptionPane.showMessageDialog(null, "Queue is Full");
        }
        // Queue is empty condition
        else if (front == -1) {
            front = 0;
            rear = 0;
            queue[rear] = data;
        }
        // Wrap rear pointer to the start if necessary
        else if (rear == size - 1 && front != 0) {
            rear = 0;
            queue[rear] = data;
        }
        // Regular case, enqueue at the next rear position
        else {
            rear = (rear + 1) % size;
            queue[rear] = data;
        }
    }

    // Method to dequeue an element from the queue
    public int deQueue() {
        // Queue is empty condition
        if (front == -1) {
            JOptionPane.showMessageDialog(null, "Queue is Empty");
            return -1;
        }

        int temp = queue[front];
        // If there's only one element in the queue
        if (front == rear) {
            front = -1;
            rear = -1;
        }
        // Wrap front pointer to the start if necessary
        else if (front == size - 1) {
            front = 0;
        }
        // Move front to the next position
        else {
            front = (front + 1) % size;
        }
        return temp;
    }

    // Method to display the elements of the queue
    public void displayQueue() {
        if (front == -1) {
            JOptionPane.showMessageDialog(null, "Queue is Empty");
            return;
        }

        StringBuilder display = new StringBuilder("Elements in the circular queue are: ");
        if (rear >= front) {
            // Case 1: When rear has not wrapped (front <= rear)
            for (int i = front; i <= rear; i++) {
                display.append(queue[i]).append(" ");
            }
        } else {
            // Case 2: When rear has wrapped around (rear < front)
            // Display from front to the end of the array
            for (int i = front; i < size; i++) {
                display.append(queue[i]).append(" ");
            }
            // Then display from 0 to rear
            for (int i = 0; i <= rear; i++) {
                display.append(queue[i]).append(" ");
            }
        }
        JOptionPane.showMessageDialog(null, display.toString());
    }

    public static void main(String[] args) {
        int size = Integer.parseInt(JOptionPane.showInputDialog("Enter circular queue capacity:"));
        CircularQueue q = new CircularQueue(size);

        while (true) {
            String[] options = {"Enqueue", "Dequeue", "Display Queue", "Exit"};
            int choice = JOptionPane.showOptionDialog(null, "Choose an operation", "Circular Queue Operations",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch (choice) {
                case 0: // Enqueue
                    int value = Integer.parseInt(JOptionPane.showInputDialog("Enter value to enqueue:"));
                    q.enQueue(value);
                    break;
                case 1: // Dequeue
                    int dequeuedValue = q.deQueue();
                    if (dequeuedValue != -1) {
                        JOptionPane.showMessageDialog(null, "Deleted value = " + dequeuedValue);
                    }
                    break;
                case 2: // Display Queue
                    q.displayQueue();
                    break;
                case 3: // Exit
                    JOptionPane.showMessageDialog(null, "Exiting the program");
                    System.exit(0);
                default:
                    break;
            }
        }
    }
}
