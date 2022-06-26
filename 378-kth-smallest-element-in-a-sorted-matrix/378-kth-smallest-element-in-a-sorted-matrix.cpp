class Solution {
public:
    int kthSmallest(vector<vector<int>>& matrix, int k) {
        int res = INT_MAX;
        priority_queue<int> pq;
        
        if(k == 1) return matrix[0][0];
        
        for(int i = 0; i < matrix.size(); i++) {
            for(int j = 0; j < matrix[i].size(); j++) {
                
                pq.push(matrix[i][j]);
                if(pq.size() == k) {
                    res = min(res, pq.top());
                    pq.pop();
                }
                
            }
        }
        
        return res;
    }
};