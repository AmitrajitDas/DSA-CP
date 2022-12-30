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
    vector<vector<string>> accountsMerge(vector<vector<string>>& accounts) {
        int n = accounts.size();
        DisjointSet ds(n);
        unordered_map<string, int> mapMailNode;
        
        // mapping mail and nodes and creating the disjointset
        for(int i = 0; i < n; i++) {
            for(int j = 1; j < accounts[i].size(); j++) {
                string mail = accounts[i][j];
                if(mapMailNode.find(mail) == mapMailNode.end()) mapMailNode[mail] = i;
                else ds.unionBySize(i, mapMailNode[mail]);
            }
        }

        // merging the mails
        vector<string> mergedMails[n];
        for(auto it : mapMailNode) {
            string mail = it.first;
            int node = ds.findParent(it.second);
            mergedMails[node].push_back(mail);
        }

        // ordering the mails with their corresponding users
        vector<vector<string>> res;
        for(int i = 0; i < n; i++) {
            if(mergedMails[i].size() == 0) continue;
            sort(mergedMails[i].begin(), mergedMails[i].end());
            vector<string> tmp;
            tmp.push_back(accounts[i][0]);
            for(auto it : mergedMails[i]) tmp.push_back(it);
            res.push_back(tmp);
        }

        return res;
    }
};