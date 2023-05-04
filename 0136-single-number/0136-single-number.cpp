class Solution {
public:
    int singleNumber(vector<int>& nums) {
        int res = 0;
        /* XOR of two same numbers is always 0 
        & XOR of a number with 0 will result in the number itself */
        for(auto &it : nums) res ^= it; 
        return res;
    }
};