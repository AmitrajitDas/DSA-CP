class Solution {
    typedef pair<int, int> P;

private:
    // Binary search function to find the index of the last '1' in a row.
    int bs(int start, int end, vector<int> row) {
        int res = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (row[mid] == 1) {
                res = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return res + 1; // Return the count of '1's in the row.
    }

public:
    vector<int> kWeakestRows(vector<vector<int>>& mat, int k) {
        int n = mat.size(), m = mat[0].size();
        priority_queue<P> pq; // Create a max-heap to store pairs (count of '1's, row index).

        for (int i = 0; i < n; i++) {
            // Find the count of '1's in the current row using binary search.
            int countOnes = bs(0, m - 1, mat[i]);
            // Push the pair (count of '1's, row index) into the max-heap.
            pq.push({countOnes, i});
            // If the max-heap size exceeds 'k', remove the row with the largest count.
            if (pq.size() > k) pq.pop();
        }

        vector<int> res(k);
        int j = k - 1;
        while (!pq.empty()) {
            res[j--] = pq.top().second;
            pq.pop();
        }

        return res; // Return the 'k' weakest row indices.
    }
};