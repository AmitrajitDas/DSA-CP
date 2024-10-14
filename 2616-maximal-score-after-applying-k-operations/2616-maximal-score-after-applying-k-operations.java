class Solution {
    public long maxKelements(int[] nums, int k) {
        // Step 1: Create a max-heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        long sum = 0;

        // Step 2: Insert all elements into the max-heap
        for (int num : nums) {
            maxHeap.offer(num);
        }

        // Step 3: Perform the k operations
        while (k > 0) {
            int maxEle = maxHeap.poll();  // Get the largest element
            sum += maxEle;  // Add the largest element to the sum
            maxHeap.offer((int)Math.ceil(maxEle / 3.0));  // Add back ceil of maxEle / 3
            k--;
        }

        return sum;  // Return the final sum
    }
}