class Solution {
    // Swap method specifically for int arrays
    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
    public void sortColors(int[] nums) {
        int n = nums.length;
        int low = 0, mid = 0, high = n - 1;

        // Traverse the array and sort the elements
        while (mid <= high) {
            if (nums[mid] == 0) {
                // Swap elements at index low and mid if the element is 0
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                // Move to the next element if the element is 1
                mid++;
            } else {
                // Swap elements at index mid and high if the element is 2
                swap(nums, mid, high);
                high--;
            }
        }
    }
}