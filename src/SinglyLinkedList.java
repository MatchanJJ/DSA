import javax.swing.JOptionPane;

public class SinglyLinkedList {

    class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    Node head = null, tail = null;

    public static void main(String[] args) {
        SinglyLinkedList listImpl = new SinglyLinkedList();
        String[] options = { "Add Node", "Add Node at Start", "Add Node at Index", "Remove Last Node",
                "Remove First Node", "Remove Node at Index", "Search", "Print List", "Exit" };
        int choice;

        do {
            choice = JOptionPane.showOptionDialog(null, "Choose an operation", "Singly Linked List Operations",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch (choice) {
                case 0: // Add Node
                    try {
                        int value = Integer.parseInt(JOptionPane.showInputDialog("Enter value to add:"));
                        listImpl.addNode(value);
                        JOptionPane.showMessageDialog(null, "Node added at the end.");
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Invalid input! Please enter an integer.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                case 1: // Add Node at Start
                    try {
                        int value = Integer.parseInt(JOptionPane.showInputDialog("Enter value to add at the start:"));
                        listImpl.addNodeAtStart(value);
                        JOptionPane.showMessageDialog(null, "Node added at the start.");
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Invalid input! Please enter an integer.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                case 2: // Add Node at Index
                    try {
                        int value = Integer.parseInt(JOptionPane.showInputDialog("Enter value to add:"));
                        int index = Integer.parseInt(JOptionPane.showInputDialog("Enter index to add at:"));
                        listImpl.addNodeAtCertainIndex(value, index);
                        JOptionPane.showMessageDialog(null, "Node added at index " + index);
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Invalid input! Please enter an integer.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                case 3: // Remove Last Node
                    listImpl.removeNode();
                    JOptionPane.showMessageDialog(null, "Last node removed.");
                    break;
                case 4: // Remove First Node
                    listImpl.removeNodeAtStart();
                    JOptionPane.showMessageDialog(null, "First node removed.");
                    break;
                case 5: // Remove Node at Index
                    try {
                        int index = Integer.parseInt(JOptionPane.showInputDialog("Enter index to remove:"));
                        listImpl.removeNodeAtCertainIndex(index);
                        JOptionPane.showMessageDialog(null, "Node at index " + index + " removed.");
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Invalid input! Please enter a valid index.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                case 6: // Search
                    try {
                        int target = Integer.parseInt(JOptionPane.showInputDialog("Enter value to search for:"));
                        boolean found = listImpl.search(target);
                        String message = found ? "Value found in the list!" : "Value not found!";
                        JOptionPane.showMessageDialog(null, message);
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Invalid input! Please enter a valid integer.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                case 7: // Print List
                    JOptionPane.showMessageDialog(null, listImpl.printLinkedList(), "Linked List", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 8: // Exit
                    JOptionPane.showMessageDialog(null, "Exiting the program.", "Exit", JOptionPane.INFORMATION_MESSAGE);
                    break;
                default:
                    break;
            }
        } while (choice != 8); // Exit the loop when the user chooses "Exit"
    }

    // Adds node at the end of the current list
    public void addNode(int val) {
        if (head == null) {
            Node temp = new Node(val);
            head = temp;
            tail = temp;
        } else {
            tail.next = new Node(val);
            tail = tail.next;
        }
    }

    // Adds node at the start of the current list
    public void addNodeAtStart(int val) {
        if (head == null) {
            Node temp = new Node(val);
            head = temp;
            tail = temp;
        } else {
            Node temp = new Node(val);
            temp.next = head;
            head = temp;
        }
    }

    // Adds node at the certain index
    public void addNodeAtCertainIndex(int val, int index) {
        Node temp = head;
        int count = 0;
        while (temp != null && ++count != index)
            temp = temp.next;
        Node node = new Node(val);
        node.next = temp.next;
        temp.next = node;
    }

    // Removes the last node in the list
    public void removeNode() {
        if (head == null) return;
        Node temp = head;
        while (temp.next != null && temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        tail = temp;
    }

    // Removes the first node in the list
    public void removeNodeAtStart() {
        if (head == null) return;
        head = head.next;
    }

    // Removes the node at the given index in the list
    public void removeNodeAtCertainIndex(int index) {
        if (head == null) return;
        Node temp = head;
        int count = 0;
        while (temp != null && ++count != index)
            temp = temp.next;
        temp.val = temp.next.val;
        temp.next = temp.next.next;
    }

    // Checks if a node with the given value exists in the list
    public boolean search(int target) {
        Node temp = head;
        while (temp != null) {
            if (temp.val == target)
                return true;
            temp = temp.next;
        }
        return false;
    }

    // Prints the current list
    public String printLinkedList() {
        StringBuilder sb = new StringBuilder();
        Node temp = head;
        while (temp != null) {
            sb.append(temp.val).append(" ");
            temp = temp.next;
        }
        return sb.length() > 0 ? sb.toString() : "List is empty.";
    }
}
