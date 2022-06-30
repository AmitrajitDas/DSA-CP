class Solution {
public:
    int minMoves2(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        int start = 0, end = nums.size() - 1;
        int mid = (start + end) / 2;
        int res = 0;
        for(int &i : nums) if(i != nums[mid]) res += abs(i - nums[mid]);
        
        return res;
    }
};