class Solution {
    typedef pair<int, int> P;

private:
    int prims(vector<vector<P>> adj, int V) {
        priority_queue<P, vector<P>, greater<P>> pq; // Create a priority queue to store edges with the smallest weight.
        vector<bool> vis(V, false); // Create a boolean array to mark visited nodes.
        int sum = 0;
        pq.push({0, 0});

        while (!pq.empty()) {
            auto p = pq.top(); // Get the edge with the smallest weight from the priority queue.
            pq.pop();
            int wt = p.first; // Extract the weight of the edge.
            int node = p.second; // Extract the node associated with the edge.

            if (vis[node]) continue; // If the node has already been visited, skip it.
            vis[node] = true; // Mark the node as visited.
            sum += wt; // Add the weight of the edge to the total sum of minimum distances.

            for (auto &it : adj[node]) {
                int adjNode = it.first; // Get the adjacent node.
                int adjNodeWt = it.second; // Get the weight of the edge to the adjacent node.

                if (!vis[adjNode]) {
                    pq.push({adjNodeWt, adjNode}); // If the adjacent node is not visited, add its edge to the priority queue.
                }
            }
        }

        return sum; // Return the total sum of minimum distances.
    }

public:
    int minCostConnectPoints(vector<vector<int>>& points) {
        int V = points.size();
        vector<vector<P>> adj(V);

        // Build the adjacency list based on the Manhattan distance between points.
        for (int i = 0; i < V; i++) {
            for (int j = i + 1; j < V; j++) {
                int x1 = points[i][0], y1 = points[i][1], x2 = points[j][0], y2 = points[j][1];
                int dis = abs(x1 - x2) + abs(y1 - y2); // Calculate the Manhattan distance.
                adj[i].push_back({j, dis});
                adj[j].push_back({i, dis});
            }
        }

        return prims(adj, V); // Apply Prim's algorithm to find the minimum cost of connecting all points.
    }
};
