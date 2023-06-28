class Solution {
public:
    double maxProbability(int n, vector<vector<int>>& edges, vector<double>& succProb, int start, int end) {
        vector<double> dist(n, 0); // min probability will always be 0
        priority_queue<pair<double, int>> pq; // {prob, node} max-heap
        vector<pair<int, double>> adj[n];
        
        // Building the directed graph
        for (int i = 0; i < edges.size(); i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double prob = succProb[i];
            adj[u].push_back({v, prob});
            adj[v].push_back({u, prob});
        }

        dist[start] = 1.0;
        pq.push({1.0, start});

        while (!pq.empty()) {
            double currProb = pq.top().first;
            int currNode = pq.top().second;
            pq.pop();
            
            // Reached the end node, no need to explore further
            if (currNode == end) break;

            for (auto& it : adj[currNode]) {
                int adjNode = it.first;
                double adjProb = it.second;
                if (currProb * adjProb > dist[adjNode]) {
                    dist[adjNode] = currProb * adjProb;
                    pq.push({dist[adjNode], adjNode});
                }
            }
        }

        return dist[end];
    }
};
