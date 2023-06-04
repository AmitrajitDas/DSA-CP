class Solution {
private:
    int DFS(int headID, vector<int>& informTime, vector<vector<int>>& adj) {
        int res = 0;
        for(auto &it : adj[headID]) res = max(res, DFS(it, informTime, adj));
        return res + informTime[headID];
    }

public:
    int numOfMinutes(int n, int headID, vector<int>& manager, vector<int>& informTime) {
        vector<vector<int>> adj(n);
        for(int i = 0; i < n; i++) {
            if(manager[i] != -1) adj[manager[i]].push_back(i);
        }
        return DFS(headID, informTime, adj);
    }
};

