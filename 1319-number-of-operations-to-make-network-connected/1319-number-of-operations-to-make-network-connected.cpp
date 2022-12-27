class DisjointSet {
    public:
    vector<int> rank, size, parent;
    DisjointSet(int n) {
        rank.resize(n + 1, 0);
        size.resize(n + 1);
        parent.resize(n + 1);
        for(int i = 0; i < n; i++) {
            size[i] = 1;
            parent[i] = i;
        }
    }

    int findParent(int node) {
        if(parent[node] == node) return node;
        return parent[node] = findParent(parent[node]);
    }

    void unionByRank(int u, int v) {
        int ulp_u = findParent(u);
        int ulp_v = findParent(v);
        if(ulp_u == ulp_v) return;
        if(rank[ulp_u] < rank[ulp_v]) parent[ulp_u] = ulp_v;
        else if(rank[ulp_u] > rank[ulp_v]) parent[ulp_v] = ulp_u;
        else {
            parent[ulp_v] = ulp_u;
            rank[ulp_u]++;
        }
    }

    void unionBySize(int u, int v) {
        int ulp_u = findParent(u);
        int ulp_v = findParent(v);
        if(ulp_u == ulp_v) return;
        if(size[ulp_u] < size[ulp_v]) {
            parent[ulp_u] = ulp_v;
            size[ulp_v] += size[ulp_u];
        } else {
            parent[ulp_v] = ulp_u;
            size[ulp_u] += size[ulp_v];
        }
    }
};

class Solution {
public:
    int makeConnected(int n, vector<vector<int>>& connections) {
        DisjointSet ds(n);
        int extras = 0; // extra edges
        for(auto it : connections) {
            int u = it[0];
            int v = it[1];
            if(ds.findParent(u) == ds.findParent(v)) extras++;
            else ds.unionBySize(u, v);
        }

        int comps = 0;
        for(int i = 0; i < n; i++) {
            if(ds.parent[i] == i) comps++;
        }

        int res = comps - 1;
        if(extras >= res) return res;
        return -1;
    }
};

