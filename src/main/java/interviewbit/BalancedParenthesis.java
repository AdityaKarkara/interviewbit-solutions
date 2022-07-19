package interviewbit;

import java.util.Stack;

public class BalancedParenthesis {
    public int solve(String A) {
        Stack<Character> stack = new Stack<>();
        for (char c : A.toCharArray()) {
            if (checkLeft(c))
                stack.push(c);
            else if (stack.isEmpty()) return 0;
            else if (!checkPair(stack.pop(), c)) return 0;
        }
        return stack.isEmpty() ? 1 : 0;
    }

    public boolean checkLeft(char a) {
        return a == '(' || a == '{' || a == '[';
    }

    public boolean checkPair(char a, char b) {
        return a == '(' && b == ')'
                ||
                a == '{' && b == '}'
                ||
                a == '[' && b == ']';
    }
}
