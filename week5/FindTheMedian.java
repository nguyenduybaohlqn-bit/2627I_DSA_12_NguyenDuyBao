import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

public class FindTheMedian {
    static int partition(List<Integer> arr, int left, int right, int k) {
        int pivot = arr.get(right);
        int i = left - 1;
        for(int j = left; j < right; j++) {
            if(arr.get(j) < pivot) {
                i++;
                Collections.swap(arr, i, j);
            }
        }
        Collections.swap(arr, i + 1, right);
        return i + 1;
    }
    public static int findMedian(List<Integer> arr, int left, int right, int k) {
        // Write your code here
        if(left == right) {
            return arr.get(left);
        }
        int pivotIndex = partition(arr, left, right, k);
        if(pivotIndex < k) {
            return findMedian(arr, pivotIndex + 1, right, k);
        }
        else if(pivotIndex == k) {
            return arr.get(pivotIndex);
        }
        return findMedian(arr, left, pivotIndex - 1, k);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Integer> arr = new ArrayList<>();
        for(int i=0;i<n;i++){
            arr.add(in.nextInt());
        }
        System.out.println(findMedian(arr, 0, arr.size() -1, arr.size() / 2));
    }
}