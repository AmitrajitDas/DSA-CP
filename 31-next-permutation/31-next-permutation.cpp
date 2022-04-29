class Solution
{
public:
    void nextPermutation(vector<int> &nums)
    {
        int n = nums.size();
        int breakPointIdx, nextGreaterIdx;
        for (int i = n - 2; i >= 0; i--)
        {
            if (nums[i] < nums[i + 1])
            {
                breakPointIdx = i;
                break;
            }
        }
        
        if (breakPointIdx < 0) reverse(nums.begin(), nums.end());
        
        else
        {
            for (int j = n - 1; j > breakPointIdx; j--)
            {
                if (nums[j] > nums[breakPointIdx])
                {
                    nextGreaterIdx = j;
                    swap(nums[breakPointIdx], nums[nextGreaterIdx]);
                    break;
                }
            }
            
            reverse(nums.begin() + breakPointIdx + 1, nums.end());
        }
    }
};