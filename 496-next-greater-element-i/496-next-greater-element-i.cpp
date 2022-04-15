class Solution {
public:
    vector<int> nextGreaterElement(vector<int>& nums1, vector<int>& nums2) {
        vector<int> res;
        stack<int> st;
        unordered_map<int, int> map;
        
        for(int i : nums2) {
            
            while(st.size() && i > st.top()) {
                map[st.top()] = i;
                st.pop();
            }
            
            st.push(i);
        }
        
        for(int i : nums1) {
            if(map.count(i))
                res.push_back(map[i]);
            else
                res.push_back(-1);
        }
        
        return res;
    }
};