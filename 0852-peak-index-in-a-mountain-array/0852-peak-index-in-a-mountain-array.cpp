class Solution {
public:
    int peakIndexInMountainArray(vector<int>& arr) {
        int n = arr.size();
        if(n == 1) return 0;
        
        // for checking peak in first/last index
        if(arr[0] > arr[1]) return 0;
        if(arr[n - 1] > arr[n - 2]) return n - 1;

        // check in the rest of the array
        int low = 1, high = n - 2;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) return mid;
            else if(arr[mid] < arr[mid + 1]) low = mid + 1;
            else if(arr[mid] < arr[mid - 1]) high = mid - 1;
        }

        return -1;
    }
};