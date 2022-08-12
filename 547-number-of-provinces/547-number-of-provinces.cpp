class Solution {
public:
    void dfs(int node, vector<bool> &vis, vector<int> adj[]) {
        vis[node] = true;
        for(auto it : adj[node]) {
            if(!vis[it]) dfs(it, vis, adj);
        }
    }

    int findCircleNum(vector<vector<int>>& isConnected) {
        int V = isConnected.size();
        vector<int> adj[V];

        // adjacency list
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if(isConnected[i][j] == 1 && i != j) {
                    adj[i].push_back(j);
                    adj[j].push_back(i);
                }
            }
        }

        vector<bool> vis(V + 1, false);
        int count = 0;
        for(int i = 0; i < V; i++) {
            if(!vis[i]) {
                count++;
                dfs(i, vis, adj);
            }
        }
        
        return count;
    }
};