class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        int n = nums.size();
        unordered_set<int> st;
        int res = 0;
        for(const auto &it : nums) st.insert(it);
        for(auto it : st) {
            // we'll only evaluate if the number is starting point of the sequence else we'll skip
            if(st.find(it - 1) == st.end()) {
                int count = 1;
                while(st.find(it + 1) != st.end()) {
                    it++;
                    count++;
                }
                res = max(res, count);
            }
        }
        return res;
    }
};