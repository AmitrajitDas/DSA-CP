class DisjointSet {
    vector<int> rank, parent;
public:
    DisjointSet(int n) {
        rank.resize(n + 1, 0);
        parent.resize(n + 1);
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }
    }

    int findUPar(int node) {
        if (node == parent[node])
            return node;
        return parent[node] = findUPar(parent[node]);
    }

    void unionByRank(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return;
        if (rank[ulp_u] < rank[ulp_v]) {
            parent[ulp_u] = ulp_v;
            rank[ulp_v] += rank[ulp_u];
        } else {
            parent[ulp_v] = ulp_u;
            rank[ulp_u]++;
        }
    }

    
};

class Solution {
public:
    int numberOfGoodPaths(vector<int>& vals, vector<vector<int> >& edges) {
        int n = vals.size();
        vector<int>adj[n];
        for (auto edge : edges) {
            adj[edge[0]].push_back(edge[1]);
            adj[edge[1]].push_back(edge[0]);
        }
       
        DisjointSet ds(n);
        map<int, vector<int> >Node;
        for (int i = 0; i < n; i++) {
            Node[vals[i]].push_back(i);
        }
        int ans = 0;

        for (auto[value, nodes] : Node) {
            for (auto node: nodes) {
                for (auto neighbour : adj[node]) {
                    if (vals[neighbour] <= vals[node]) {
                        ds.unionByRank(node, neighbour);
                    }
                }
            }

            unordered_map<int, int>freq;
            for (auto node : nodes) {
                freq[ds.findUPar(node)]++;
            }
            for (auto it : freq) {
                int count = (it.second * (it.second+1)) / 2;
                ans += count;
            }
        }
        return ans;  
        
    }
};