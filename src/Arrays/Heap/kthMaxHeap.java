package Arrays.Heap;

import java.util.PriorityQueue;

public class kthMaxHeap {
    public static void main(String[] args) {
        int[] arr = {7,10,4,3,20,15};
        int k = 3;

        int result = findKthHighest(arr, k);

        System.out.println("Kth Highest: " + result);


        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : arr) {
            minHeap.offer(num);

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        System.out.println("Kth Highest: " + minHeap.peek());
    }


    public static int findKthHighest(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : arr) {
            minHeap.offer(num);

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }
}
