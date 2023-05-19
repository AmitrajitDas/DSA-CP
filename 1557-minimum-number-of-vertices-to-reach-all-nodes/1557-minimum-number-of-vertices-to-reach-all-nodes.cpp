// TC: O(N + E), SC: O(N)
class Solution {
public:
    vector<int> findSmallestSetOfVertices(int n, vector<vector<int>>& edges) {
        vector<bool> indegree (n, false);
        vector<int> res;
        for(auto &edge : edges) indegree[edge[1]] = true; // nodes with 0 indegree can reach all nodes
        for(int i = 0; i < n; i++) if(!indegree[i]) res.push_back(i);
        return res;
    }
};