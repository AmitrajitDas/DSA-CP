class Solution {
private:
    int dfs(int node, vector<int> adj[], vector<bool> &vis, vector<bool> &hasApple) {
        int apples = 0;
        vis[node] = true;

        for(auto &it : adj[node]) {
            if(!vis[it]) apples += dfs(it, adj, vis, hasApple);
        }

        if(node == 0) return apples;
        if(hasApple[node] || apples > 0) apples += 2; // 2 because to reach a subtree we go and return

        return apples;
    }
public:
    int minTime(int n, vector<vector<int>>& edges, vector<bool>& hasApple) {
        vector<int> adj[n];

        for(auto &it : edges) { // building the undirected graph
            adj[it[0]].push_back(it[1]);
            adj[it[1]].push_back(it[0]);
        }

        vector<bool> vis(n, false);
        return dfs(0, adj, vis, hasApple); 
    }
};