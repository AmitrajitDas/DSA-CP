class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> dq = new ArrayDeque<>(); // Deque to store indices of elements
        ArrayList<Integer> list = new ArrayList<>(); // ArrayList to store maximum values

        for (int i = 0; i < n; i++) {
            // Remove indices that are out of the current window
            while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.removeFirst();
            }

            // Remove indices of smaller elements as they are no longer candidates for maximum
            while (!dq.isEmpty() && nums[i] > nums[dq.peekLast()]) {
                dq.removeLast();
            }

            // Add the current index to the deque
            dq.addLast(i);

            // When the window is of size k, add the maximum value to the list
            if (i >= k - 1) {
                // Use the stored index to get the value from nums
                list.add(nums[dq.peekFirst()]);
            }
        }

        // Convert the ArrayList to an array of integers
        int[] res = list.stream().mapToInt(Integer::intValue).toArray();
        return res;
    }
}
