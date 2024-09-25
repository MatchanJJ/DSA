public interface StackADT {
    void push(int element);
    int pop();
    int peek();
    boolean isEmpty();
    boolean isFull(); // Optional, for bounded stacks
    int size(); // Optional
}
