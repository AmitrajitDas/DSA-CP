class Solution {
public:
    int minOperations(vector<int>& nums, int x) {
        int n = nums.size();
        unordered_map<int, int> mp;
        int sum = 0;
        mp[0] = -1; // Initialize the hashmap with an entry for the prefix sum 0 and index -1.

        // Calculate and store prefix sums and their indices in the hashmap.
        for(int i = 0; i < n; i++) {
            sum += nums[i];
            mp[sum] = i;
        }

        // If the total sum of the array is less than x, there is no way to achieve x by operations.
        if(sum < x) return -1;
        
        int len = INT_MIN;
        int remSum = sum - x; // Calculate the sum that needs to be found in the prefix sums.
        sum = 0;

        // Iterate through the array to find the maximum subarray length that achieves the remaining sum.
        for(int i = 0; i < n; i++) {
            sum += nums[i];
            int findSum = sum - remSum; // Calculate the prefix sum to find in the hashmap.
            if(mp.find(findSum) != mp.end()) {
                int idx = mp[findSum];
                len = max(len, i - idx);
            }
        }
        
        return len == INT_MIN ? -1 : (n - len);
    }
};
