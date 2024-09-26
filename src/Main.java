public class Main {
    public static void main(String[] args) {
        StackADT stack = new ArrayStack(5);
            String str = "Hello";
            for (int i=0; i<str.length();i++){
                char reversed = str.charAt(i);
                stack.push(reversed);
            }
            for (int j = 0; j < str.length();j++){
                System.out.print(stack.pop());
            }


        }
    }


