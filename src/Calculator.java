import java.util.*;

public class Calculator {

    public static void main(String[] args) {
        String str = "(8+2*5)/(1+3*2-4)";
        System.out.println("Prefix: " + str);
        if (BracketCheck.checkBrackets(str)) {
            System.out.println("Postfix: " + Postfix.toPostFix(str));
            System.out.println("Result = " + Calculate(Postfix.toPostFix(str)));
        } else
            System.out.println("Error brackets");
    }

    /**
     * Calculate postfix expression
     * @param postfix string with postfix expression
     * @return value of result
     */
    private static float Calculate(String postfix) {
        Stack<Integer> operands = new Stack<>();
        int left, right;

        for (int i = 0; i < postfix.length(); i++) {
            char ch = postfix.charAt(i);
            switch (ch) {
                case '+':
                    right = operands.isEmpty() ? 0 : operands.pop();
                    left = operands.isEmpty() ? 0 : operands.pop();
                    //calc += right + left;
                    operands.push(right + left);
                    continue;
                case '-':
                    right = operands.isEmpty() ? 0 : operands.pop();
                    left = operands.isEmpty() ? 0 : operands.pop();
                    operands.push(left - right);
                    continue;
                case '*':
                    right = operands.isEmpty() ? 1 : operands.pop();
                    left = operands.isEmpty() ? 1 : operands.pop();
                    operands.push(right * left);
                    continue;
                case '/':
                    right = operands.isEmpty() ? 1 : operands.pop();
                    left = operands.isEmpty() ? 1 : operands.pop();
                    operands.push(left / right);
                    continue;
                default:
                    operands.push(Character.getNumericValue(ch));
            }
        }
        return operands.pop();
    }
}
