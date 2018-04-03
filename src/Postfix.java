import java.util.*;

public class Postfix {

    public static void main(String[] args) {
        String str = "(8+2*5)/(1+3*2—4)";
        if(BracketCheck.checkBrackets(str))
            System.out.println(toPostFix(str));
    }

    /**
     * Set the infix exception to postfix
     * @param infix string with expression
     * @return return the postfix expression
     */
    static String toPostFix(String infix) {
        String postfix = "";
        if(BracketCheck.checkBrackets(infix)) {
            Stack<Character> operators = new Stack<>();
            char popped;
            for (int i = 0; i < infix.length(); i++) {
                char character = infix.charAt(i);

                if (!isOperator(character))
                    postfix += character;
                else if (character == ')')
                    while ((popped = operators.pop()) != '(')
                        postfix += popped;
                else {
                    while (!operators.isEmpty() && character != '('
                            && priority(operators.peek()) >= priority(character))
                        postfix += operators.pop();
                    operators.push(character);
                }
            }
            while (!operators.isEmpty())
                postfix += operators.pop();
        }
        return postfix;
    }

    /**
     * Checks if this is operator
     * @param ch current character in string
     * @return return true if operator
     */
    private static boolean isOperator(char ch) {
        return priority(ch) > 0;
    }

    /**
     * @param ch checks character in string
     * @return returns priority value
     */
    private static int priority(char ch) {
        switch (ch) {
            case '(':
            case ')':
                return 1;
            case '-':
            case '+':
                return 2;
            case '*':
            case '/':
                return 3;
            default:
                return 0;
        }
    }
}
