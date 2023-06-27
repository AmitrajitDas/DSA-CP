class Solution {
public:
    vector<vector<int>> kSmallestPairs(vector<int>& nums1, vector<int>& nums2, int k) {
        int n = nums1.size(), m = nums2.size();
        priority_queue<pair<int, pair<int, int>>> pq;
        vector<vector<int>> res;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                int sum = nums1[i] + nums2[j];
                if(pq.size() < k) pq.push({sum, {nums1[i], nums2[j]}});
                else if(sum < pq.top().first) { // to reduce TC
                    pq.pop();
                    pq.push({sum, {nums1[i], nums2[j]}});
                } else break; // to reduce TC
            }
        }

        while(!pq.empty()) {
            auto it = pq.top();
            vector<int> arr = {it.second.first, it.second.second};
            res.push_back(arr);
            pq.pop();
        }

        reverse(res.begin(), res.end());
        return res;
    }
};