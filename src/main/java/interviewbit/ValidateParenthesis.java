package interviewbit;

import java.util.Stack;

public class ValidateParenthesis {
    public int isValid(String A) {
        Stack<Character> stack = new Stack<>();
        for (char ch : A.toCharArray()) {
            if (ch == '[' || ch == '{' || ch == '(') {
                stack.push(ch);
            } else if (stack.isEmpty() || !isClosingParenthesis(stack.pop(), ch)) {
                return 0;
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }

    public boolean isClosingParenthesis(char start, char end) {
        return start == '[' && end == ']'
                || start == '{' && end == '}'
                || start == '(' && end == ')';
    }

    public static void main(String[] args) {
        String input = "{([]])}";
        System.out.println(new ValidateParenthesis().isValid(input) == 0);
    }
}
