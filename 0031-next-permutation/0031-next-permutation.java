class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int breakpoint = -1;

        // 1. Find the breakpoint (first decreasing element from right)
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                breakpoint = i;
                break;
            }
        }

        // 2. If no breakpoint, array is in descending order; just reverse it all
        if (breakpoint == -1) {
            reverse(nums, 0, n - 1);
            return;
        }

        // 3. Find the smallest number larger than nums[breakpoint] to its right
        for (int i = n - 1; i > breakpoint; i--) {
            if (nums[i] > nums[breakpoint]) {
                swap(nums, i, breakpoint); // Corrected swap arguments
                break;
            }
        }

        // 4. Reverse the portion after the breakpoint
        reverse(nums, breakpoint + 1, n - 1);
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private void reverse(int[] array, int start, int end) {
        while (start < end) {
            swap(array, start++, end--);
        }
    }
}