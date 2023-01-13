class Solution {
    void dfs(int node, int prevNode, vector<int> adj[],
                           string& labels, vector<int>& ans,  unordered_map<int, int>& freqMap) {
        // Maintain a count of freq till now.
        int prevCount = freqMap[labels[node] - 'a'];

        freqMap[labels[node] - 'a'] += 1;
        // Count the no. of chars in all the child subtrees.
        for (int nextNode : adj[node]) {
            if (prevNode == nextNode) continue;
            dfs(nextNode, node, adj, labels, ans, freqMap);
        }

        ans[node] = freqMap[labels[node] - 'a'] - prevCount;
    }

public:
    vector<int> countSubTrees(int n, vector<vector<int>>& edges, string labels) {
        vector<int> adj[n];

        for (vector<int>& edge : edges) {
            adj[edge[0]].push_back(edge[1]);
            adj[edge[1]].push_back(edge[0]);
        }

        vector<int> ans(n, 0);
        unordered_map<int, int> freqMap;
        dfs(0, 0, adj, labels, ans, freqMap);

        return ans;
    }
};