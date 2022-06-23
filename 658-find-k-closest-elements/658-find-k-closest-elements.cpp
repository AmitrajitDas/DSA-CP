class Solution {
public:
    vector<int> findClosestElements(vector<int>& arr, int k, int x) {
        priority_queue<pair<int, int>> pq; // we are using max heap to ommit the bigger values from the top of the heap
        
        for(int it : arr) {
            int diff = abs(x - it);
            pq.push({diff, it}); // we push the pair of abs difference as the key so that max heap sorts them by the differences
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