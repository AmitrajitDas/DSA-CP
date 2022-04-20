class Solution {
public:
    
    void findCombo(vector<int> &arr, int idx, vector<vector<int>> &res, vector<int> &ds, int target) {
        
        if(idx == arr.size()) {
            if(target == 0)
                res.push_back(ds);
            return;
        }
        
        
        if(arr[idx] <= target) {
            ds.push_back(arr[idx]);
            findCombo(arr, idx, res, ds, target - arr[idx]);
            ds.pop_back();
        }  
        
        findCombo(arr, idx + 1, res, ds, target);
    }
    
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
    
        int idx = 0;
        vector<vector<int>> res;
        vector<int> ds;
        findCombo(candidates, idx, res, ds, target);
        return res;
    }
};