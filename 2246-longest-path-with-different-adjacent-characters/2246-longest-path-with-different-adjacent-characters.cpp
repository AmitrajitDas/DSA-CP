class Solution {
private:
    int dist[100005];
    int ans = 1;
    void dfs(int node, vector<int> adj[], string &s) {
        dist[node] = 1;
        for(auto &child : adj[node]) {
            dfs(child, adj, s);
            if(s[node] != s[child]) { // as we need nodes with distinct characters
                ans = max(dist[node] + dist[child], ans); // tracing max path
                dist[node] = max(1 + dist[child], dist[node]); // updating current node
            }
        }
    }
public:
    int longestPath(vector<int>& parent, string s) {
        int n = parent.size();
        vector<int> adj[n];
        for(int i = 1; i < n; i++) adj[parent[i]].push_back(i); // building the graph
        dfs(0, adj, s);
        return ans;
    }
};