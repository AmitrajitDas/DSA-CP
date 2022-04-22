class Solution {
public:
    
    void findPermute(vector<int> &nums, vector<int> &ds, vector<vector<int>> &res, vector<bool> &map) {
        
        if(ds.size() == nums.size()) {
            res.push_back(ds);
            return;
        }
        
        for(int i = 0; i < nums.size(); i++) {
            if(!map[i]) {
                map[i] = true;
                ds.push_back(nums[i]);
                findPermute(nums, ds, res, map);
                map[i] = false;
                ds.pop_back();
            }
        }
        
    }
    
    vector<vector<int>> permute(vector<int>& nums) {
        vector<vector<int>> res;
        vector<int> ds;
        vector<bool> map(nums.size(), false);
        findPermute(nums, ds, res, map);
        return res;
    }
};