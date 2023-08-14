class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Create a min-heap priority queue to store the k largest elements
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num : nums) {
            pq.add(num);

            // If the size of the priority queue exceeds k, remove the smallest element (top of the heap)
            // This removes the smallest element (min-heap behavior)
            if (pq.size() > k) pq.poll();
        }

        // The kth largest element will be at the top of the priority queue
        return pq.peek();
    }
}
