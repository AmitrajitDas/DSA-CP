class DisjointSet {
    vector<int> parent;
public:
    DisjointSet(int n) {
        parent.resize(n + 1);
        for(int i = 0; i < n; i++) parent[i] = i;
    }

    int findUParent(int node) {
            if(node == parent[node]) return node;
            return parent[node] = findUParent(parent[node]);
    }

    void unify(int u, int v) {
        int ulp_u = findUParent(u);
        int ulp_v = findUParent(v);
        if(ulp_u == ulp_v) return;
        // lexicographical priority
        if(ulp_u < ulp_v) parent[ulp_v] = ulp_u;
        else parent[ulp_u] = ulp_v;
    }
};

class Solution {
public:
    string smallestEquivalentString(string s1, string s2, string baseStr) {
        DisjointSet ds(26);
        for(int i = 0; i < s1.size(); i++) {
            int char1 = s1[i] - 'a';
            int char2 = s2[i] - 'a';
            ds.unify(char1, char2);
        }

        string res = "";
        for(int i = 0; i < baseStr.size(); i++) {
            int smallestEqChar = ds.findUParent(baseStr[i] - 'a'); // getting the ultimate parent of baseStr characters
            res += (char)(smallestEqChar + 'a');
        }

        return res;
    }
};