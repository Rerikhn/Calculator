import java.util.*;

public class BracketCheck {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the exception: ");
        String str = scan.nextLine();
        System.out.println(str);
        System.out.println(checkBrackets(str) ? "OK\n" : "Error\n");
    }

    /**
     * Check the brackets for correct input
     * @param str input string
     * @return return true if correct
     */
    static boolean checkBrackets(String str) {
        Stack<Character> stk = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            switch (ch) {
                case '(':
                case '{':
                case '[':
                    stk.push(ch);
                    break;
                case ')':
                case '}':
                case ']':
                    if (!stk.isEmpty()) {
                        char chx = stk.pop(); // pop and check
                        if ((ch == '}' && chx != '{') || (ch == ']' && chx != '[')
                                || (ch == ')' && chx != '('))
                            System.out.println("Error: " + ch + " at " + i);
                    } else System.out.println("Error: " + ch + " at " + i);
                    break;
            }
        }
        return stk.empty();
    }
}
