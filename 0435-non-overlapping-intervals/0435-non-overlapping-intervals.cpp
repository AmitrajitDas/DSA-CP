class Solution {
public:
    int eraseOverlapIntervals(vector<vector<int>>& intervals) {
        sort(intervals.begin(), intervals.end(), [](const vector<int> &a, const vector<int> &b) -> bool {
            return a[1] < b[1];
        });
        int res = 0;
        vector<int> prev = intervals[0];
        for(int i = 1; i < intervals.size(); i++) {
            if(intervals[i][0] < prev[1]) res++;
            else prev = intervals[i];
        }

        return res;
    }
};