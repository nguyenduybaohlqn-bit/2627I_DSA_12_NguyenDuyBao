import java.util.Stack;
import java.util.Scanner;

public class w3_tailop_25021650 {
    static int uutien(char op) {
        if (op == '+' || op == '-') {
            return 1;
        }
        if (op == '*' || op == '/') {
            return 2;
        }
        return 0;
    }
    static String solve(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isWhitespace(c)) {
                continue;
            }
            if (Character.isDigit(c)) {
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    res.append(s.charAt(i));
                    i++;
                }
                res.append(' ');
                i--;
            }
            else if (Character.isLetter(c)) {
                res.append(c);
                res.append(' ');
            }
            else if (c == '+' || c == '-' || c == '*' || c == '/') {
                while (!st.isEmpty()
                        && uutien(st.peek()) >= uutien(c)) {
                    res.append(st.pop());
                    res.append(' ');
                }
                st.push(c);
            }
        }
        while (!st.isEmpty()) {
            res.append(st.pop());
            res.append(' ');
        }
        return res.toString().trim();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(solve(s));
    }
}