class Solution {
public:
    bool dfs(int i, int color, vector<int> &colors, vector<vector<int>> &graph) {
        if (colors[i] != 0) {
            return colors[i] == color;
        }    
        
        colors[i] = color;
        for(auto it : graph[i]) {
            if(!dfs(it, -color, colors, graph)) 
                return false;
            
        }
        
        return true;
    }
    
    bool isBipartite(vector<vector<int>>& graph) {
        int v = graph.size();
        vector<int> colors(v+1);
        for(int i = 0; i < v; i++) {
            if(colors[i] == 0 && !dfs(i, 1, colors, graph)) return false;
        }
        
        return true;
    }
};