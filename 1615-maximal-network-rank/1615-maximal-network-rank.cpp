class Solution {
public:
    int maximalNetworkRank(int n, vector<vector<int>>& roads) {
        vector<int> degree(n);
        vector<vector<bool>> connected(n, vector<bool>(n, false));
        
        for(auto &road : roads) {
            int u = road[0];
            int v = road[1];
            
            // Increment the degrees of nodes u and v
            degree[u]++;
            degree[v]++;
            
            // Mark the nodes as connected in the matrix
            connected[u][v] = true;
            connected[v][u] = true;
        }
        
        int maxRank = 0;

        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                
                int i_rank = degree[i];
                int j_rank = degree[j];
                
                int rank = i_rank + j_rank;
                
                // Decrement the rank if there's a road between nodes i and j, or j and i
                if(connected[i][j] || connected[j][i]) rank--;
                maxRank = max(maxRank, rank);
                
            }
        }
        
        return maxRank;
    }
};
