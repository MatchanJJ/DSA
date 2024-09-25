public class Main {
    public static void main(String[] args) {
        StackADT stack = new ArrayStack(5);

        stack.push(10);
        stack.push(20);
        System.out.println("Top element is: " + stack.peek());

        while (!stack.isEmpty()) {
            System.out.println("Popped: " + stack.pop());
        }
    }
}
