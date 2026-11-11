import java.util.*;

class Main {
    public static List<Double> runningMedian(List<Integer> a) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        List<Double> result = new ArrayList<>();
        for (int x : a) {
            if (maxHeap.isEmpty() || x <= maxHeap.peek()) {
                maxHeap.offer(x);
            } else {
                minHeap.offer(x);
            }
            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.offer(maxHeap.poll());
            } else if (minHeap.size() > maxHeap.size() + 1) {
                maxHeap.offer(minHeap.poll());
            }
            double median;
            if (maxHeap.size() == minHeap.size()) {
                median = ((double) maxHeap.peek() + minHeap.peek()) / 2.0;
            } else if (maxHeap.size() > minHeap.size()) {
                median = maxHeap.peek();
            } else {
                median = minHeap.peek();
            }
            result.add(median);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            a.add(sc.nextInt());
        }
        List<Double> result = runningMedian(a);
        for (double median : result) {
            System.out.printf(Locale.US, "%.1f%n", median);
        }
        sc.close();
    }
}