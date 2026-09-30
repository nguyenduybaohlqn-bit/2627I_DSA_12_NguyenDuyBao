import java.util.Stack;
import java.util.Scanner;

public class BalancedBracket {
    public static String isBalanced(String s) {
        // Write your code here
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                st.push(c);
            }
            else {
                if(!st.isEmpty()) {
                    char first = st.peek();
                    if((first == '(' && c == ')') || (first == '{' && c == '}') || (first == '[' && c == ']')) {
                        st.pop();
                    }
                    else {
                        return "NO";
                    }
                }
                else {
                    return "NO";
                }
            }
        }
        if(st.isEmpty()) {
            return "YES";
        }
        else {
            return "NO";
        }
    }

}
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    sc.nextLine(); 
    for (int i = 0; i < n; i++) {
        String s = sc.nextLine();
        System.out.println(isBalanced(s));
    }
}
}