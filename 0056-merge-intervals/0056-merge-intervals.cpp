class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        int n = intervals.size();
        vector<vector<int>> res;
        if (n == 0) return res; // If input is empty, return an empty result
        
        sort(intervals.begin(), intervals.end()); // Sort intervals based on start times
        
        // Initialize a temporary interval with the first interval in the input
        vector<int> temp = intervals[0];

        for (int i = 1; i < n; i++) {
            // If the current interval overlaps with the temporary interval
            if (intervals[i][0] <= temp[1])
                temp[1] = max(temp[1], intervals[i][1]); // Merge the overlapping intervals
            else {
                res.push_back(temp); // If no overlap, push the merged interval to the result
                temp = intervals[i]; // Update temporary interval to the current interval
            }
        }

        res.push_back(temp); // Push the last remaining or merged interval to the result
        return res;
    }
};
