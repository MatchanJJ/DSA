import java.util.EmptyStackException;

public class ArrayStack extends StackADT {
    private int maxSize;
    private int top;
    private int[] stackArray;

    public ArrayStack(int size) {
        this.maxSize = size;
        this.stackArray = new int[maxSize];
        this.top = -1;
    }

    @Override
    public void push(int element) {
        if (isFull()) {
            throw new StackOverflowError("Stack Overflow! Cannot push " + element);
        } else {
            stackArray[++top] = element;
        }
    }

    @Override
    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            return stackArray[top--];
        }
    }

    @Override
    public int peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            return stackArray[top];
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
