class Solution{
    private:
    vector<int> topoSort(vector<int> adj[], int V) {
        vector<int> indegree(V, 0);
        for(int i = 0; i < V; i++) {
            for(auto it : adj[i]) indegree[it]++;
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
        
        return topo;
    }
    
    public:
    string findOrder(string dict[], int N, int K) {
        
        vector<int> adj[K];
        
        for(int i = 0; i < N - 1; i++) {
            string s1 = dict[i], s2 = dict[i + 1];
            int len = min(s1.size(), s2.size());
            for(int j = 0; j < len; j++) {
                if(s1[j] != s2[j]) {
                    adj[s1[j] - 'a'].push_back(s2[j] - 'a'); // getting the ASCII values for graph nodes
                    break;
                }
            }
        }
        
        vector<int> topo = topoSort(adj, K); // we get a topo sorted array, now we'll convert it into a string
        
        string res = "";
        for(auto it : topo) {
            res += char(it + 'a'); // converting ASCII values to corresponding characters
        }
        
        return res;
    }
};
