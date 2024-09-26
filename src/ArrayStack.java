import java.util.EmptyStackException;

public class ArrayStack extends StackADT {
    private int maxSize;
    private int top;
    private char[] stackArray; // Change from String[] to char[]

    public ArrayStack(int size) {
        this.maxSize = size;
        this.stackArray = new char[maxSize]; // Initialize as char array
        this.top = -1;
    }

    @Override
    public void push(char element) { // Change parameter type to char
        if (isFull()) {
            throw new StackOverflowError("Stack Overflow! Cannot push " + element);
        } else {
            stackArray[++top] = element; // Store char element
        }
    }

    @Override
    public char pop() { // Return type remains char
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            return stackArray[top--]; // Return char element
        }
    }

    @Override
    public char peek() { // Return type remains char
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            return stackArray[top]; // Return char element
        }
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public boolean isFull() {
        return top == maxSize - 1;
    }

    @Override
    public int size() {
        return top + 1; // Returns the number of elements
    }
}
