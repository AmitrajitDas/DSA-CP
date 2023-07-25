class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        int start = 0, end = n - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            
            /* Check if the element at mid index is less than the element at mid+1 index
            If it is, then the peak must be on the right side of the mid index,
            so update the start index to mid + 1 */
            if (arr[mid] < arr[mid + 1]) {
                start = mid + 1;
            } 
            /* If the element at mid index is greater than or equal to the element at mid+1 index,
             then the peak must be on the left side of the mid index,
             so update the end index to mid */
            else {
                end = mid;
            }
        } 
        
        // At the end of the loop, the start index will point to the peak index in the mountain array
        return start;
    }
}
