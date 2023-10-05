class Solution {
public:
    vector<int> majorityElement(vector<int>& nums) {
        int n = nums.size();
        int maj1, maj2;
        int count1 = 0, count2 = 0;
        
        // First pass: Find two potential majority candidates
        for(int i = 0; i < n; i++) {
            if(nums[i] == maj1) {
                count1++; // Increment count for candidate 1
            } else if(nums[i] == maj2) {
                count2++; // Increment count for candidate 2
            } else if(count1 == 0) {
                maj1 = nums[i]; // Set candidate 1
                count1 = 1; // Reset count for candidate 1
            } else if(count2 == 0) {
                maj2 = nums[i]; // Set candidate 2
                count2 = 1; // Reset count for candidate 2
            } else {
                // If neither candidate matches, decrement both counts
                count1--;
                count2--;
            }
        }

        // Second pass: Count the occurrences of the two potential majority candidates
        int freq1 = 0, freq2 = 0;
        for(auto it : nums) {
            if(it == maj1) freq1++;
            else if(it == maj2) freq2++;
        }

        vector<int> res;
        
        // Check if the candidates are indeed majorities
        if(freq1 > floor(n / 3)) res.push_back(maj1);
        if(freq2 > floor(n / 3)) res.push_back(maj2);

        return res;
    }
};
