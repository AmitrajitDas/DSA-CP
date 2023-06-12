class Solution {
public:
    vector<string> summaryRanges(vector<int>& nums) {
        int rngStart = 0, rngEnd = 0, n = nums.size();
        vector<string> res;
        if(n == 0 ) return res;
        for(int i = 0; i < n; i++) {
            if(i == n - 1 || nums[i + 1] != nums[i] + 1) {
                // this implies that range is found
                if(nums[i] != nums[rngStart]) 
                    res.push_back(to_string(nums[rngStart]) + "->" + to_string(nums[i]));
                else res.push_back(to_string(nums[rngStart])); // if no range is found
                // to evaluate next range without getting out of bounds
                if(i != n - 1) rngStart = i + 1;
            }
        }

        return res;
    }
};