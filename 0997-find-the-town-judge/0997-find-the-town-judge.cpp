class Solution {
public:
    int findJudge(int n, vector<vector<int>>& trust) {
        if(n == 1 && trust.empty()) return 1;
        vector<int> out(n + 1, 0), in(n + 1, 0);
        for(auto &it : trust) {
            out[it[0]]++;
            in[it[1]]++;
        }

        //if a node has outdegree==0 that means that node doesnot trust anyone and
		//indegree ==n-1 that means all other nodes trusts this node except himself
        for(int i = 1; i <= n; i++) {
            if(out[i] == 0 && in[i] == n - 1) return i;
        }

        return -1;
    }
};