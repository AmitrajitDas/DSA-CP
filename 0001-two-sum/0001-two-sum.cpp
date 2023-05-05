// TC: O(N), SC: O(N)

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int, int> mp;
        vector<int> res;
        for(int i = 0; i < nums.size(); i++) {
            if(mp.find(target - nums[i]) != mp.end()) { // hashing the indices reduces calculations
                res.push_back(mp[target - nums[i]]);
                res.push_back(i);
            }
            mp[nums[i]] = i;
        }
        return res;
    }
};