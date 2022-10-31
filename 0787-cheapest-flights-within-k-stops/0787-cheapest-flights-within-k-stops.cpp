class Solution {
public:
    int findCheapestPrice(int n, vector<vector<int>>& flights, int src, int dst, int k) {
        vector<pair<int, int>> adj[n];
        for(auto it : flights) adj[it[0]].push_back({it[1], it[2]}); // adjacency list
        vector<int> dist (n, 1e9);
        dist[src] = 0;
        queue<pair<int, pair<int, int>>> q;
        q.push({0, {src, 0}}); // {k, {node, cost}}
        
        while(!q.empty()) {
            auto it = q.front();
            q.pop();
            int stops = it.first;
            int node = it.second.first, cost = it.second.second;
            
            if(stops > k) break;
            
            for(auto itr : adj[node]) {
                int adjNode = itr.first, edgeWt = itr.second;
                if(cost + edgeWt < dist[adjNode] && stops <= k) {
                    dist[adjNode] = cost + edgeWt;
                    q.push({stops + 1, {adjNode, dist[adjNode]}});
                }
            }
        }
        
        return dist[dst] == 1e9 ? -1 : dist[dst];
    }
};