class Solution {
public:
    int minimumOperations(vector<int>& nums) {
        int n = nums.size(), count = 0;
        vector<int> tmp;
        tmp.push_back(nums[0]); // Initialize tmp with the first element of nums
        
        for(int i = 1; i < n; i++) {
            // Find the position to insert the current element using binary search
            auto start = lower_bound(tmp.begin(), tmp.end(), nums[i]);
            auto end = upper_bound(tmp.begin(), tmp.end(), nums[i]);
            
            if(end == tmp.end()) {
                // If the current element is greater than all elements in tmp,
                // push it to the back of tmp
                tmp.push_back(nums[i]);
            } else {
                // Otherwise, update the element at the correct position with
                // the minimum of the current element and the existing element
                // to maintain the increasing order
                int idx = end - tmp.begin();
                tmp[idx] = min(tmp.back(), nums[i]); // Using tmp.back() to access the last element
                count++; // Increment the count of operations
            }
        }
        
         for(int i = 0; i < tmp.size(); i++) {
             cout << tmp[i];
         }
        
        return count; // Return the minimum number of operations
    }
};
