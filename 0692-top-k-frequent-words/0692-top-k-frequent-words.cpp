class Solution {
private:
    struct comp {
        bool operator() (const pair<string, int>& a, const pair<string, int>& b) {
            if(a.second == b.second) return a.first < b.first;
            return a.second > b.second;
        }
    };
public:
    vector<string> topKFrequent(vector<string>& words, int k) {
        unordered_map<string, int> hashmap;
        for(string& word : words) {
            hashmap[word] += 1;
        }
        priority_queue<pair<string, int>, vector<pair<string, int>>, comp> pq;
        for(auto it = hashmap.begin(); it != hashmap.end(); ++it) {
            pq.push(make_pair(it->first, it->second));
            if(pq.size() > k) pq.pop();
        }
        vector<string> res;
        while(!pq.empty()) {
            res.insert(res.begin(), pq.top().first);
            pq.pop();
        }
        return res;
    }
};