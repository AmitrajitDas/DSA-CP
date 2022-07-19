class Solution {
public:
    
    void backtrack(vector<int> &nums, vector<bool> &freq, vector<int> &arr, vector<vector<int>> &res) {
        
        if(arr.size() == nums.size()) {
            res.push_back(arr);
            return;
        }
        
        for(int i = 0; i < nums.size(); i++) {
            if(!freq[i]) {
                arr.push_back(nums[i]);
                freq[i] = true;
                backtrack(nums, freq, arr, res);
                freq[i] = false;
                arr.pop_back();
            }
        }
    }
    
    vector<vector<int>> permute(vector<int>& nums) {
        vector<int> arr;
        vector<bool> freq(nums.size(), false);
        vector<vector<int>> res;
        backtrack(nums, freq, arr, res);
        return res;
    }
};