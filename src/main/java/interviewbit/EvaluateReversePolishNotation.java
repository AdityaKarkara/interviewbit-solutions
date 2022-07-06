package interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class EvaluateReversePolishNotation {
    public int evalRPN(ArrayList<String> A) {
        Stack<String> stack = new Stack<>();
        for (String str : A) {
            if (isOperator(str)) {
                int b = Integer.parseInt(stack.pop());
                int a = Integer.parseInt(stack.pop());
                int res = performOperation(a, b, str);
                stack.push(Integer.toString(res));
            } else {
                stack.push(str);
            }
        }
        return Integer.parseInt(stack.pop());
    }

    public boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }

    public int performOperation(int a, int b, String op) {
        switch(op) {
            case "+": {
                return a + b;
            }
            case "-": {
                return a - b;
            }
            case "*": {
                return a * b;
            }
            case "/": {
                return (int) a / b;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("4", "13", "5", "/", "+"));
        int ans = new EvaluateReversePolishNotation().evalRPN(list);
        System.out.println(ans == 6);
    }
}
