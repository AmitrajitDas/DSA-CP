class Solution {
private:
    bool isPoss(int target, vector<int>& nums) {
        int n = nums.size();
        vector<long long int> arr(nums.begin(), nums.end());
        for(int i = 0; i < n - 1; i++) {
            if(arr[i] > target) return false;
            arr[i + 1] -= target - arr[i];
        }
        
        return arr[n - 1] <= target;
    }
public:
    int minimizeArrayValue(vector<int>& nums) {
        int start = 0, end = 1e9;
        
        while(start < end) {
            int mid = (start + end) >> 1;
            if(isPoss(mid, nums)) end = mid;
            else start = mid + 1;
        }
        
        return start;
    }
};