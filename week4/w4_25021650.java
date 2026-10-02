import java.util.Scanner;
import java.util.Arrays;
import java.util.*;

public class w4_25021650 {
    public static int solve(List<Integer> lst, int n) {
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (lst.get(j) < lst.get(minIndex)) {
                    minIndex = j;
                }
            }
            int temp = lst.get(i);
            lst.set(i, lst.get(minIndex));
            lst.set(minIndex, temp);
        }
        for(int i = n - 1; i >= 0; i--) {
            if(lst.get(n - i - 1) > i) {
                return (i + 1);
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> lst = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            lst.add(sc.nextInt());
        }
        System.out.println(solve(lst, n));
    }
}