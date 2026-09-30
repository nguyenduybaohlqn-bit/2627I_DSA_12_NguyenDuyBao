import java.util.Scanner;
import java.util.Arrays;

public class EqualStacks {
    public static int sum(List<Integer> lst) {
        int sum = 0;
        for (int x : lst) {
            sum += x;
        }
        return sum;
    }
    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        List<List<Integer>> stacks = new ArrayList<>();
        stacks.add(h1);
        stacks.add(h2);
        stacks.add(h3);

        int[] heights = new int[3];
        for (int k = 0; k < 3; k++) heights[k] = sum(stacks.get(k));
        int min = Math.min(heights[0], Math.min(heights[1], heights[2]));

        int[] index = new int[3];
        int i = 0;
        while (heights[0] != heights[1] || heights[2] != heights[1]) {
            while (heights[i] > min && index[i] < stacks.get(i).size()) {
                heights[i] -= stacks.get(i).get(index[i]);
                index[i]++;
            }
            min = Math.min(min, heights[i]);
            i = (i + 1) % 3;
        }
        return min;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        List<Integer> h1 = new ArrayList<>();
        List<Integer> h2 = new ArrayList<>();
        List<Integer> h3 = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            h1.add(sc.nextInt());
        }

        for (int i = 0; i < m; i++) {
            h2.add(sc.nextInt());
        }

        for (int i = 0; i < k; i++) {
            h3.add(sc.nextInt());
        }

        System.out.println(equalStacks(h1, h2, h3));
    }
}