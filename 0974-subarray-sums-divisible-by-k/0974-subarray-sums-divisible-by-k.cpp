class Solution {
public:
    int subarraysDivByK(vector<int>& nums, int k) {
        unordered_map<int, int> mp;
        mp[0] = 1;
        int count = 0, prefixSum = 0;
        for(int &it : nums) {
            prefixSum += it;
            int rem = prefixSum % k;
            if(rem < 0) rem += k;
            if(mp.find(rem) != mp.end()) count += mp[rem];
            mp[rem]++;
        }
        return count;
    }
};