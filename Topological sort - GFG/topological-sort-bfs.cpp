// { Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
class Solution
{	
public:
    void topoBFS(queue<int> q, vector<int> adj[], vector<int> &in, vector<int> &res) {
        
        while(!q.empty()) {
            int temp = q.front();
            q.pop();
            res.push_back(temp);
            for(auto it : adj[temp]) {
                in[it]--;
                if(in[it] == 0)
                    q.push(it);
            }
            
        }
    }
    

	//Function to return list containing vertices in Topological order. 
	vector<int> topoSort(int V, vector<int> adj[]) 
	{
	   vector<int> in(V+1, 0);
	   vector<int> res;
	   for(int i = 0; i < V; i++) {
	       for(auto it : adj[i])
	            in[it]++;
	   }    
	   
	   queue<int> q;
	   
	   for(int i = 0; i < V; i++) {
	       if(in[i] == 0)
	            q.push(i);
	   }
	   
	   topoBFS(q, adj, in, res);
	   
	   return res;
	}
};

// { Driver Code Starts.

/*  Function to check if elements returned by user
*   contains the elements in topological sorted form
*   V: number of vertices
*   *res: array containing elements in topological sorted form
*   adj[]: graph input
*/
int check(int V, vector <int> &res, vector<int> adj[]) {
    
    if(V!=res.size())
    return 0;
    
    vector<int> map(V, -1);
    for (int i = 0; i < V; i++) {
        map[res[i]] = i;
    }
    for (int i = 0; i < V; i++) {
        for (int v : adj[i]) {
            if (map[i] > map[v]) return 0;
        }
    }
    return 1;
}

int main() {
    int T;
    cin >> T;
    while (T--) {
        int N, E;
        cin >> E >> N;
        int u, v;

        vector<int> adj[N];

        for (int i = 0; i < E; i++) {
            cin >> u >> v;
            adj[u].push_back(v);
        }
        
        Solution obj;
        vector <int> res = obj.topoSort(N, adj);

        cout << check(N, res, adj) << endl;
    }
    
    return 0;
}  // } Driver Code Ends
