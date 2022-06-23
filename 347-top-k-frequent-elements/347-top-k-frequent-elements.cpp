class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        unordered_map<int, int> map; // we store the freq in hashmap so that we can sort by their freq in the heap
        for(int it : nums) map[it]++;
        
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq; // min-heap
        for(auto it = map.begin(); it != map.end(); it++) {
            pq.push({it->second, it->first});
            if(pq.size() > k) pq.pop();
        }
        
        vector<int> res;
        while(!pq.empty()) {
            res.push_back(pq.top().second);
            pq.pop();
        }
        
        return res;
    }
};