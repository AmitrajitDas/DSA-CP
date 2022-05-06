class Solution
{
	public:
	//Function to find sum of weights of edges of the Minimum Spanning Tree.
    int spanningTree(int V, vector<vector<int>> adj[]) {
        vector<int> key(V, INT_MAX);
        vector<bool> mst(V, false);
        vector<int> parent(V, -1);
        priority_queue<pair<int,int>, vector<pair<int,int>>, greater<pair<int,int>>> pq;
        
        key[0] = 0;
        pq.push({0, 0}); // pair {dist, node}
        
        for(int i = 0; i < V - 1; i++) {
            int v = pq.top().second;
            pq.pop();
            mst[v] = true;
            
            for(auto it : adj[v]) {
                int u = it[0];
                int weight = it[1];
                if(weight < key[u] && !mst[u]) { // we'll check if mst index is false and current adj weight < previous weight
                    parent[u] = v;
                    key[u] = weight;
                    pq.push({weight, u});
                }
            }
        }
        
        int sum = 0;
        for(auto it : key) sum += it;
        
        return sum;
    }
};
