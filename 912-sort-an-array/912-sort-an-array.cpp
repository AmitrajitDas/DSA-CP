class Solution {
public:
    vector<int> sortArray(vector<int>& nums) {
        priority_queue<int, vector<int>, greater<int>> pq;
        vector<int> res;
        
        for(int it : nums)
            pq.push(it);
        
        while(!pq.empty()) {
            int temp = pq.top();
            pq.pop();
            res.push_back(temp);
        }
        
        return res;
    }
};