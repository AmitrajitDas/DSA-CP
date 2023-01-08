class Solution {
public:
    int maxPoints(vector<vector<int>>& points) {
        int n = points.size();
        if(n <= 0) return 0;
        if(n <= 2) return n;

        int maxi = 0;
        for(vector<int> &it1 : points) {
            unordered_map<double, int> mp;
            for(vector<int> &it2 : points) {
                if(it1 == it2) continue; // if both co-ordinates are same
                double slope = 0;
                if(it1[0] == it2[0]) slope = 1e9; // if x co-ordinate is same then the line will be vertical
                else slope = (double)(it2[1] - it1[1])/(double)(it2[0] - it1[0]); // m = y2 - y1/x2 - x1
                mp[slope]++;
                if(mp[slope] > maxi) maxi = mp[slope];
            }
        }

        return maxi + 1; // we need to add one extra as we are comparing with a base co-ord from the input vector
    }
};