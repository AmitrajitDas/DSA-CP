///////// TOPO SORT ///////////

class Solution {
public:
    vector<int> eventualSafeNodes(vector<vector<int>>& graph) {
        int V = graph.size();
        vector<vector<int>> adj(V);
        vector<int> indegree (V, 0);
        
        for(int i = 0; i < V; i++) {
            for(auto it : graph[i]) {
                adj[it].push_back(i);
                indegree[i]++;
            }
        }
        
        queue<int> q;
        for(int i = 0; i < V; i++) {
            if(indegree[i] == 0) q.push(i);
        }
        
        vector<int> topo;
        while(!q.empty()) {
            int node = q.front();
            q.pop();
            topo.push_back(node);
            
            for(auto it : adj[node]) {
                if(--indegree[it] == 0) q.push(it);
            }
        }
        
        sort(topo.begin(), topo.end());
        return topo;
    }
};

// class Solution {
// private:
//     bool dfs(int node,vector<int>& vis,vector<int>& path, vector<vector<int>>& graph){
//         vis[node] = 1;
//         path[node] =1;
        
//         for(auto it: graph[node]){
//             if(!vis[it] && !path[it]){
//                 if(dfs(it,vis,path,graph) == true){
//                     return true;
//                 }
//             }
//             else if(vis[it] && path[it]){
//                 return true;
//             }
//         }
//         path[node] = 0;
//         return false;
//     }
// public:
//     vector<int> eventualSafeNodes(vector<vector<int>>& graph) {
//         vector<int> safeNodes;
//         int n=graph.size();
//         vector<int> vis(n,0);
//         vector<int> path(n,0);
        
//         for(int i=0;i<n;i++){
//             if(!vis[i]){
//                 dfs(i,vis,path,graph);
//             }
//         }
//         for(int i=0;i<n;i++){
//             if(!path[i]) safeNodes.push_back(i);
//         }
//         return safeNodes;
//     }
// };