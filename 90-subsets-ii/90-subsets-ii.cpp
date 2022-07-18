class Solution {
public:
    
    void backtrack(int ind, vector<int>& nums, vector<int> &arr, vector<vector<int>> &res) {
        
        res.push_back(arr);
        
        for(int i = ind; i < nums.size(); i++) {
            if(i > ind && nums[i] == nums[i - 1]) continue;
            arr.push_back(nums[i]);
            backtrack(i + 1, nums, arr, res);
            arr.pop_back();
        }
        
    }
    
    vector<vector<int>> subsetsWithDup(vector<int>& nums) {
        vector<int> arr;
        vector<vector<int>> res;
        sort(nums.begin(), nums.end());
        backtrack(0, nums, arr, res);
        return res;
    }
};