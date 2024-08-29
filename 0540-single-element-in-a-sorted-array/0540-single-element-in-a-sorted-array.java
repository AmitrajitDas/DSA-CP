class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length; 
        int low = 0, high = n - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            /* Check the pattern in the array to determine which side to search next
            If mid is even and nums[mid] == nums[mid + 1], the unique element is in the right half
            OR
            If mid is odd and nums[mid] == nums[mid - 1], the unique element is also in the right half */
            if (mid % 2 == 0 && nums[mid] == nums[mid + 1] || (mid % 2 == 1 && nums[mid] == nums[mid - 1])) {
                low = mid + 1;  // Move the low pointer to the right half
            } else {
                high = mid;  // Otherwise, move the high pointer to the left half or mid itself
            }
        }

        // When low == high, we've found the unique element
        return nums[low];
    }
}
