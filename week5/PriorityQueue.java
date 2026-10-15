class PriorityQueue {
    private int[] arr;
    private int size;
    private int K;

    public PriorityQueue(int K) {
        this.K = K;
        arr = new int[K];
        size = 0;
    }

    public void insert(int x) {
        arr[size] = x;
        size++;
    }

    public int deleteMin() {
        int minIndex = 0;
        for (int i = 1; i < size; i++) {
            if (arr[i] < arr[minIndex]) {
                minIndex = i;
            }
        }
        int minValue = arr[minIndex];
        for (int i = minIndex; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
        return minValue;
    }
}