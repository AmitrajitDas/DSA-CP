class Solution {
public:
    static bool comp(pair<int, int> &a, pair<int, int> &b) {
        return a.second > b.second;
    }
    
    int maxPerformance(int n, vector<int>& speed, vector<int>& efficiency, int k) {
        vector<pair<int, int>> eng;
        
        for(int i = 0; i < n; i++) {
            eng.push_back({speed[i], efficiency[i]});
        }
        
        sort(eng.begin(), eng.end(), comp);
        priority_queue<int, vector<int>, greater<int>> minHeap;
        long long res = 0, speedSum = 0;
        
        for (auto&[s, e] : eng) {
            speedSum += s;
            minHeap.push(s);
            if(minHeap.size() > k) {
                speedSum -= minHeap.top();
                minHeap.pop();
            }
            
            // as eff is in decreasing order we don't need to minimize eff as the current one is already minimzied
            res = max(speedSum * e, res); 
        }
        
        return res % (int) (1e9 + 7);
    }
};