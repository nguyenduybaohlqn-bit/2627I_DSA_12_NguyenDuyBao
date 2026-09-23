public class LocalMinimum {
    public static int localMin(int[] a) {
        int l = 0;
        int r = a.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (a[m] < a[m + 1]) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int index = localMin(a);
        System.out.println(a[index]);
    }
}