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
            
            // if we reach destination with k+1 move then stop 
            // iteration as we reached destination with atmost 
            // k stops 
            if(stops > k) break;
            
            for(auto itr : adj[node]) {
                int adjNode = itr.first, edgeWt = itr.second;
                if(cost + edgeWt < dist[adjNode] && stops <= k) {
                    dist[adjNode] = cost + edgeWt; // update the distance 
                    q.push({stops + 1, {adjNode, dist[adjNode]}});  // push the adj element and new distance into queue
                }
            }
        }
        
        // if the distance of the dst is not changed the return -1
        // as it is not possible to reach destination
        return dist[dst] == 1e9 ? -1 : dist[dst];
    }
};