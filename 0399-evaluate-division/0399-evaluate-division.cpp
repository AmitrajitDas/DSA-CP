class Solution {
private:
    double dfs(string src, string target, double currWeight, unordered_map<string, unordered_map<string, double>>& adj, unordered_set<string>& visited) {
        if (src == target) return currWeight;
        visited.insert(src);
        for (const auto& [node, weight] : adj[src]) {
            if (visited.find(node) == visited.end()) {
                double result = dfs(node, target, currWeight * weight, adj, visited);
                if (result != -1.0) return result;
            }
        }
        return -1.0;
    }

public:
    vector<double> calcEquation(vector<vector<string>>& equations, vector<double>& values, vector<vector<string>>& queries) {
        unordered_map<string, unordered_map<string, double>> adj;
        vector<double> res;
        
        // Build the graph
        for (int i = 0; i < equations.size(); i++) {
            const string& dividend = equations[i][0];
            const string& divisor = equations[i][1];
            const double quotient = values[i];
            
            adj[dividend][divisor] = quotient;
            adj[divisor][dividend] = 1.0 / quotient;
        }
        
        // Evaluate queries
        for (const auto& query : queries) {
            const string& src = query[0];
            const string& target = query[1];

            if (!adj.count(src) || !adj.count(target)) res.push_back(-1.0);
            else {
                unordered_set<string> visited;
                res.push_back(dfs(src, target, 1.0, adj, visited));
            }
        }
        
        return res;
    }
};
