package Arrays.Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class kthMinHeap {
    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 3, 20, 15};
        int k = 3;

        int kthLowest = findKthLowest(arr, k);

        System.out.println("Kth Lowest: " + kthLowest);
    }

    public static int findKthLowest(int[] arr, int k) {
        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>(Collections.reverseOrder());

        for (int num : arr) {
            maxHeap.offer(num);

            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        return maxHeap.peek();
    }
}
