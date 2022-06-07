class Solution {
public:
    bool isBipartite(vector<vector<int>>& graph) {
        
        int V = graph.size();
        vector<int> vis(V, -1);
        
        for(int i = 0; i < V; i++) {
            if(vis[i] == -1) {
                vis[i] = 0;
                queue<int> q;
                q.push(i);
                
                while(!q.empty()) {
                    int node = q.front();
                    q.pop();
                    for(auto it : graph[node]) {
                        int color = 1 - vis[node]; // alternate color
                        if(vis[it] == -1) {
                            q.push(it);
                            vis[it] = color;
                        } else if(vis[node] == vis[it]) // if any node has same color as its parent then graph is not bipartite
                            return false; 
                    }
                }
            }
        }
        
        return true;
    }
};