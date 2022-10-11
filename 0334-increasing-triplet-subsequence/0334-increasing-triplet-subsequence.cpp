class Solution {
public:
    bool increasingTriplet(vector<int>& nums) {
        // start with two largest values, as soon as we find a number bigger than both, while both have been updated,                   return true.
        int s = INT_MAX, l = INT_MAX; 
        
        for(int n : nums) {
            if(n <= s) s = n;  // update s if n is smaller than both
            else if(n <= l) l = n; // update l only if greater than s but smaller than l
            else return true; // return if a number bigger than both is found
        } 
        
        return false;
    }
};