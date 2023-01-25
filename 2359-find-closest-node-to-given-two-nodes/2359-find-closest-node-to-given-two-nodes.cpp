class Solution {
public:
    int closestMeetingNode(vector<int>& edges, int node1, int node2) {
        int n = edges.size();
        vector<int> dist1(n, -1), dist2(n, -1);
        // distance from any node to itself is zero
        dist1[node1] = 0;
        dist2[node2] = 0;

        int i = node1, dist = 0;
        while(true) {
            dist1[i] = dist++;
            i = edges[i]; // dfs
            if(i == -1 || dist1[i] != -1) break; // i == -1 is unreachable and dist1[i] != -1 is for cycle
        }

        i = node2, dist = 0;
         while(true) {
            dist2[i] = dist++;
            i = edges[i]; // dfs
            if(i == -1 || dist2[i] != -1) break; // i == -1 is unreachable and dist2[i] != -1 is for cycle
        }

        int res = -1, mini = INT_MAX;

        for(int i = 0; i < n; i++) {
            if(dist1[i] == -1 || dist2[i] == -1) continue;
            if(mini > max(dist1[i], dist2[i])) { // minimizing the max distance
                mini = max(dist1[i], dist2[i]);
                res = i;
            }
        }

        return res;
    }
};