// { Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
class Solution {
  public:
    // Function to detect cycle in a directed graph.
    bool isCyclic(int V, vector<int> adj[]) {
        vector<int> in(V, 0);
        queue<int> q;
        int count = 0;
        
        for(int i = 0; i < V; i++) {
            for(auto it : adj[i])
                in[it]++;
        }
        
        for(int i = 0; i < V; i++) {
            if(in[i] == 0) q.push(i);
        }
        
        while(!q.empty()) {
            int node = q.front();
            q.pop();
            count++;
            for(auto it : adj[node]) {
                in[it]--;
                if(in[it] == 0) q.push(it);
            }
        }
        
        return count == V ? false : true;
    }
    
};

// { Driver Code Starts.

int main() {

    int t;
    cin >> t;
    while (t--) {
        int V, E;
        cin >> V >> E;

        vector<int> adj[V];

        for (int i = 0; i < E; i++) {
            int u, v;
            cin >> u >> v;
            adj[u].push_back(v);
        }

        Solution obj;
        cout << obj.isCyclic(V, adj) << "\n";
    }

    return 0;
}
  // } Driver Code Ends