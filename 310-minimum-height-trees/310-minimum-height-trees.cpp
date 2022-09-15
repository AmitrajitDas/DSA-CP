class Solution {
public:
    vector<int> findMinHeightTrees(int n, vector<vector<int>>& edges) {
        if(n==0)
            return {};
        if(n==1)
            return {0};
        
        vector<int> degree(n, 0);
        vector<int> adj[n];
        
        // bulding adjacency list and degree
        for(int i = 0; i < edges.size(); i++) {
            adj[edges[i][0]].push_back(edges[i][1]);
            adj[edges[i][1]].push_back(edges[i][0]);
            degree[edges[i][0]]++;
            degree[edges[i][1]]++;
        }
        
        queue<int> q;
        for(int i = 0; i < n; i++) {
            if(degree[i] == 1) q.push(i);
        }
        
        vector<int> topo;
        while(!q.empty()) {
            topo.clear(); // clear vector before we start traversing level by level.
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int node = q.front();
                q.pop();
                topo.push_back(node);
            
                for(auto it : adj[node]) {
                    if(--degree[it] == 1) q.push(it);
                }
            }
        }
        
        return topo;
    }
};