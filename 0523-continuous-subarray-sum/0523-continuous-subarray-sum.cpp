class Solution {
public:
    bool checkSubarraySum(vector<int>& nums, int k) {
        unordered_map<int, int> mp;
        mp[0] = -1;
        int n = nums.size(), currSum = 0;
        if(n < 2) return false;
        for(int i = 0; i < n; i++) {
            currSum += nums[i];
            if(k != 0) currSum %= k;
            if(mp.find(currSum) != mp.end()) {
                if(i - mp[currSum] > 1) return true;
            } else mp[currSum] = i;
        }

        return false;
    }
};