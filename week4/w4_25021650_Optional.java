import java.util.*;

public class w4_25021650_Optional {
    public static void solve(List<Integer> lst) {
        Collections.sort(lst, (a, b) -> {
            String ab = String.valueOf(a) + String.valueOf(b);
            String ba = String.valueOf(b) + String.valueOf(a);
            return ba.compareTo(ab);
        });
        for(int i = 0; i < lst.size(); i++) {
            System.out.print(lst.get(i));
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> lst = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            lst.add(sc.nextInt());
        }
        solve(lst);
    }
}