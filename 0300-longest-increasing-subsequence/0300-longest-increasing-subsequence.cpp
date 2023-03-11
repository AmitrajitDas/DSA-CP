class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        vector<int> temp;
        temp.push_back(nums[0]);
        for(int i = 1; i < nums.size(); i++) {
            if(nums[i] > temp.back()) temp.push_back(nums[i]);
            else {
                int idx = lower_bound(temp.begin(), temp.end(), nums[i]) - temp.begin();
                temp[idx] = nums[i];
            }
        }

        return temp.size();
    }
};

////// DP ///////

// class Solution {
// public:
//     int lengthOfLIS(vector<int>& nums) {
//         int n = nums.size();
//         vector<int> dp(n, 1);
//         for(int i = 0; i < n; i++){
//             for(int j = 0; j < i; j++){
//                 if(nums[i] > nums[j]){
//                     dp[i] = max(dp[i], dp[j] + 1);
//                 }
//             }
//         }
//         return *max_element(dp.begin(), dp.end());
//     }
// };