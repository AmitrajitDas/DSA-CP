class Solution {
public:
    int sumOfBeauties(vector<int>& nums) {
        int n = nums.size();
        vector<int> minOnRight(n, 0);
        minOnRight[n - 1] = nums[n - 1];

        // loop for maintaing values of minimum on the right
        for(int i = n - 2; i >= 2; i--){
            minOnRight[i] = min(minOnRight[i + 1], nums[i]);           
        }

        int maxOnLeft = nums[0], res = 0;
        for(int i = 1; i < n - 1; i++){
            if(nums[i] > maxOnLeft && nums[i] < minOnRight[i + 1]) res += 2;
            else if(nums[i] > nums[i - 1] && nums[i] < nums[i + 1]) res += 1;
            maxOnLeft = max(nums[i], maxOnLeft);
        }

        return res;
    }
};