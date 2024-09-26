import java.util.Stack;

public class ParenthesesMatcher {

    public static boolean isMatched(String expression) {
        Stack<Character> stack = new Stack<>();

        // Iterate through each character in the expression
        for (char ch : expression.toCharArray()) {
            // Push opening parentheses onto the stack
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            // Check for closing parentheses
            else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty()) {
                    return false; // Unmatched closing parenthesis
                }
                char top = stack.pop();
                // Check for matching pairs
                if (!isMatchingPair(top, ch)) {
                    return false; // Mismatched pair
                }
            }
        }

        // If stack is empty, all parentheses are matched
        return stack.isEmpty();
    }

    private static boolean isMatchingPair(char opening, char closing) {
        return (opening == '(' && closing == ')') ||
                (opening == '{' && closing == '}') ||
                (opening == '[' && closing == ']');
    }

    public static void main(String[] args) {
        String expression = "(a + b) * {c / [d - e]}";
        if (isMatched(expression)) {
            System.out.println("The parentheses are matched.");
        } else {
            System.out.println("The parentheses are not matched.");
        }
    }
}
