class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        // Ensure nums1 is the smaller array for efficiency
        if (n1 > n2) return findMedianSortedArrays(nums2, nums1);
        
        int low = 0, high = n1;
        int totalLength = n1 + n2;
        int halfLength = (n1 + n2 + 1) / 2;

        while (low <= high) {
            // Partition both arrays
            int mid1 = low + (high - low) / 2;
            int mid2 = halfLength - mid1;

            // Left and right bounds of nums1
            int l1 = (mid1 == 0) ? Integer.MIN_VALUE : nums1[mid1 - 1];
            int r1 = (mid1 == n1) ? Integer.MAX_VALUE : nums1[mid1];

            // Left and right bounds of nums2
            int l2 = (mid2 == 0) ? Integer.MIN_VALUE : nums2[mid2 - 1];
            int r2 = (mid2 == n2) ? Integer.MAX_VALUE : nums2[mid2];

            // Correct partition found
            if (l1 <= r2 && l2 <= r1) {
                if (totalLength % 2 == 0) {
                    // If even, median is the average of the two middle values
                    return ((double)Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                } else {
                    // If odd, median is the max of the left side
                    return Math.max(l1, l2);
                }
            } else if (l1 > r2) {
                // Move left in nums1
                high = mid1 - 1;
            } else {
                // Move right in nums1
                low = mid1 + 1;
            }
        }

        return 0;
    }
}