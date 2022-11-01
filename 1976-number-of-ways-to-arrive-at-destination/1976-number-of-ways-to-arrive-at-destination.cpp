class Solution {    
public:
    int countPaths(int n, vector<vector<int>>& roads) {
        // adjacency list
        vector<pair<int, int>> adj[n];

        // create the graph
        for (auto &v : roads) {
            adj[v[0]].push_back({v[1], v[2]});
            adj[v[1]].push_back({v[0], v[2]});
        }
        
        int mod = 1e9 + 7;
        // priority queue for keep track of min distance 
        priority_queue<pair<long long, long long>, vector<pair<long long, long long>>, greater<pair<long long, long long>>> pq;
        // store the distance and number of paths
        vector<long long> dis(n, 1e18), path(n, 0);

        // push the initial node and distance to reach start is 0
        pq.push({0, 0});
        // mark the distance to 0
        dis[0] = 0;
        // mark the path number to 1
        path[0] = 1;

        // until queue is not empty
        while (!pq.empty()) {
            // get the top (min distance) element from priority queue and remove
            long long dist = pq.top().first;
            int node = pq.top().second;
            pq.pop();

            // iterate on its adjacent nodes
            for (auto &child : adj[node]) {
                int adjNode = child.first;
                long long wt = child.second;

                // if it min distance to reach at a node then update it
                if (dist + wt < dis[adjNode]) {
                    dis[adjNode] = dist + wt;
                    path[adjNode] = path[node];
                    pq.push({dist + wt, adjNode});
                }
                else if (dist + wt == dis[adjNode]) {
                    //if it already visited with the shortest dis then increse the path with the current node path
                    path[adjNode] = (path[node] + path[adjNode]) % mod;
                }
            }
        }

        return path[n - 1];
    }
};