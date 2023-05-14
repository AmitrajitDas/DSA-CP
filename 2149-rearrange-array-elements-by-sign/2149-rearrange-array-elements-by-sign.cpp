// TC: O(N), SC: O(N)
class Solution {
public:
    vector<int> rearrangeArray(vector<int>& nums) {
        int n = nums.size();
        vector<int> pos;
        vector<int> neg;
        for (int i = 0; i < n; i++) {
            if(nums[i] < 0) neg.push_back(nums[i]);
            else pos.push_back(nums[i]);
        }

        int i = 0, j = 0;
        vector<int> res;
        while(i < n/2 && j < n/2) {
            res.push_back(pos[i++]);
            res.push_back(neg[j++]);
        }

        return res;
    }
};