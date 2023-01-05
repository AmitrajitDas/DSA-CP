class Solution {
public:
    int findMinArrowShots(vector<vector<int>>& points) {
        // sorting the array based on 2nd index
        sort(points.begin(), points.end(), [](const vector<int> &a, const vector<int> &b) -> bool {
            return a[1] < b[1];
        });

        for(int i = 0; i < points.size(); i++) {
            for(int j = 0; j < points[i].size(); j++) {
                cout << points[i][j] << endl;
            }
        }

        int arrows = 1, reach = points[0][1];
        for(int i = 1; i < points.size(); i++) {
            if(points[i][0] > reach) { // if start point is out of reach then we need extra arrows
                arrows++;
                reach = points[i][1];
            }
        }

        return arrows;
    }
};