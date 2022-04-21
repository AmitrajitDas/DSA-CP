class Solution {
public:
    
    void findSubsets(vector<int>& nums, int idx, vector<int> &ds, vector<vector<int>> &res) {
        
        if(idx == nums.size()) {
            res.push_back(ds);
            return;
        }
        
        //take
        ds.push_back(nums[idx]);
        findSubsets(nums, idx + 1, ds, res);
        
        //not take
        ds.pop_back();
        findSubsets(nums, idx + 1, ds, res);
    }
    
    vector<vector<int>> subsets(vector<int>& nums) {
        
        vector<vector<int>> res;
        vector<int> ds;
        int idx = 0;
        findSubsets(nums, idx, ds, res);
        return res;
    }
};