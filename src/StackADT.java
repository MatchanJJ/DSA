abstract class StackADT {
    // Abstract method for pushing an element onto the stack
    abstract void push(char element);

    // Abstract method for popping an element from the stack
    abstract char pop();

    // Abstract method for peeking at the top element of the stack
    abstract char peek();

    // Method to check if the stack is empty
    abstract boolean isEmpty();

    // Optional method to check if the stack is full (for bounded stacks)
    abstract boolean isFull();

    // Optional method to get the size of the stack
    abstract int size();
}
