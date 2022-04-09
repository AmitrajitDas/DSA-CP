class Solution {
    
    struct node {
        int num;
        int freq;
        node(int _num, int _freq) {
            num = _num;
            freq = _freq; 
        }
    };
    
    struct comp {
        // max-heap
        bool operator() (const node& x, const node& y) {
            return x.freq < y.freq;    
        }
    };
    
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        
        unordered_map<int, int> map;
        vector<int> res;
        
        for(auto x : nums)
            map[x]++;
        
        priority_queue<node, vector<node>, comp> pq;
        
        for(auto x : map)
            pq.push(node(x.first, x.second));
        
        while(k--) {
            node tmp = pq.top();
            res.push_back(tmp.num);
            pq.pop();
        }
        
        return res;
        
    }
};