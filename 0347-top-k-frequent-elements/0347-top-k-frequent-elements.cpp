class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        unordered_map<int, int> freq;
        priority_queue<pair<int, int>> pq; // max-heap as we'll give frequency priority
        vector<int> res;

        for(const auto &it : nums) freq[it]++;
        
        for(auto it = freq.begin(); it != freq.end(); it++) {
            pq.push({it->second, it->first});
            if(pq.size() > freq.size() - k) {
                res.push_back(pq.top().second);
                pq.pop(); // if pq size surpasses k then we remove the front element
            }
        }
        
        return res;
    }
};