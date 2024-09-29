import java.util.*;

class Node {
    protected int data;
    protected Node link;

    // Constructor
    public Node() {
        link = null;
        data = 0;
    }

    // Constructor with parameters
    public Node(int d, Node n) {
        data = d;
        link = n;
    }

    // Function to set link to next Node
    public void setLink(Node n) {
        link = n;
    }

    // Function to set data to current Node
    public void setData(int d) {
        data = d;
    }

    // Function to get link to next node
    public Node getLink() {
        return link;
    }

    // Function to get data from current Node
    public int getData() {
        return data;
    }
}

class LinkedQueue {
    protected Node front, rear;
    public int size;

    // Constructor
    public LinkedQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    // Function to check if queue is empty
    public boolean isEmpty() {
        return front == null;
    }

    // Function to get the size of the queue
    public int getSize() {
        return size;
    }

    // Function to insert an element to the queue
    public void insert(int data) {
        Node nptr = new Node(data, null);
        if (rear == null) {
            front = nptr;
            rear = nptr;
        } else {
            rear.setLink(nptr);
            rear = rear.getLink();
        }
        size++;
    }

    // Function to remove front element from the queue
    public int remove() {
        if (isEmpty()) throw new NoSuchElementException("Underflow Exception");
        Node ptr = front;
        front = ptr.getLink();
        if (front == null) rear = null;
        size--;
        return ptr.getData();
    }

    // Function to check the front element of the queue
    public int peek() {
        if (isEmpty()) throw new NoSuchElementException("Underflow Exception");
        return front.getData();
    }

    // Function to display the status of the queue
    public void display() {
        System.out.print("\nQueue = ");
        if (size == 0) {
            System.out.print("Empty\n");
            return;
        }
        Node ptr = front;
        while (ptr != null) {
            System.out.print(ptr.getData() + " ");
            ptr = ptr.getLink();
        }
        System.out.println();
    }
}

// Class to implement LinkedQueue with menu
public class LinkedListQueue {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LinkedQueue lq = new LinkedQueue();
        int choice;
        do {
            System.out.println("\nQueue Operations Menu:");
            System.out.println("1. Insert element");
            System.out.println("2. Remove element");
            System.out.println("3. Peek front element");
            System.out.println("4. Check if queue is empty");
            System.out.println("5. Display queue size");
            System.out.println("6. Display queue contents");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            while (!scan.hasNextInt()) {
                System.out.println("Please enter a valid number.");
                scan.next();
            }
            choice = scan.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter integer element to insert: ");
                    while (!scan.hasNextInt()) {
                        System.out.println("Invalid input. Please enter an integer.");
                        scan.next();
                    }
                    lq.insert(scan.nextInt());
                    break;
                case 2:
                    try {
                        System.out.println("Removed Element = " + lq.remove());
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        System.out.println("Peek Element = " + lq.peek());
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("Is queue empty? " + lq.isEmpty());
                    break;
                case 5:
                    System.out.println("Queue size = " + lq.getSize());
                    break;
                case 6:
                    lq.display();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 0);

        scan.close();
    }
}
