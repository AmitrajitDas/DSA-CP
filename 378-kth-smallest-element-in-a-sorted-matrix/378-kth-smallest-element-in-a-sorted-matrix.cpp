///// Binary Search /////

class Solution {
public:
    int n, m;
    int countLessOrEqual(vector<vector<int>>& matrix, int mid) {
        int col = m - 1, count = 0;
        for(int row = 0; row < n; row++) {
            while(col >= 0 && matrix[row][col] > mid) col--;
            count += col + 1;
        }
        
        return count;
    }
    
    int kthSmallest(vector<vector<int>>& matrix, int k) {
        n = matrix.size(), m = matrix[0].size();
        int l = matrix[0][0], h = matrix[n - 1][n - 1];
        int res;
        while(l <= h) {
            int mid = (l + h) / 2;
            if(countLessOrEqual(matrix, mid) >= k) {
                res = mid;
                h = mid - 1;
            } else l = mid + 1;
        }
        
        return res;
    }
};

///// MAX HEAP /////

// class Solution {
// public:
//     int kthSmallest(vector<vector<int>>& matrix, int k) {
//         priority_queue<int> pq;
        
//         for(int i = 0; i < matrix.size(); i++) {
//             for(int j = 0; j < matrix[i].size(); j++) {
//                 pq.push(matrix[i][j]);
//                 if(pq.size() > k) pq.pop();    
//             }
//         }
        
//         return  pq.top();
//     }
// };