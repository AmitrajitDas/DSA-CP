class Solution {
public:
    vector<int> findClosestElements(vector<int>& arr, int k, int x) {
        priority_queue<pair<int, int>> pq;
        
        for(int it : arr) {
            int diff = abs(x - it);
            pq.push({diff, it});
            if(pq.size() > k) pq.pop();
        }
        
        vector<int> res;
        while(!pq.empty()) {
            res.push_back(pq.top().second);
            pq.pop();
        }
        
        sort(res.begin(), res.end());
        
        return res;
    }
};