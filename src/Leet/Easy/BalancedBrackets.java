package Leet.Easy;

import java.util.Stack;

public class BalancedBrackets {
    public static char[][] TOKENS = {{'(', ')'}, {'[', ']'}, {'{', '}'}};

    public static void main(String[] args) {
        String input = "[()]{}{[()()]()}";

        if (isBalanced(input)) {
            System.out.println("This is balanced");
        }
    }

    public static boolean isOpenTerm(Character c)
    {
        for (char[] array: TOKENS) {
            if (array[0] == c) {
                return true;
            }
        }
        return false;
    }

    public static boolean matches(Character openTerm, Character closeTerm)
    {
        for (char[] array: TOKENS) {
            if (array[0] == openTerm) {
                return array[1] == closeTerm;
            }
        }

        return false;
    }

    public static boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<>();

        for (Character c : expression.toCharArray()) {
            if (isOpenTerm(c)) {
                stack.push(c);
            } else if (stack.empty() || !matches(stack.pop(), c)) {
                return false;
            }
        }

        return stack.empty();
    }
}
