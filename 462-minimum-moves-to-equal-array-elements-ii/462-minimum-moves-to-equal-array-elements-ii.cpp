class Solution {
public:
    int minMoves2(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        int mid = nums.size()/2;
        int res = 0;
        for(int &i : nums) if(i != nums[mid]) res += abs(i - nums[mid]);
        
        return res;
    }
};