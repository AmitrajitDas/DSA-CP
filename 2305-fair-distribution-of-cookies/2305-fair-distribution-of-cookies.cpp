class Solution {
private:
    int res = INT_MAX;
    void solve(int idx, int k, vector<int>& children, vector<int>& cookies) {
        if(idx >= cookies.size()) {
            int unfairness = *max_element(begin(children), end(children));
            res = min(res, unfairness);
            return;
        }

        for(int i = 0; i < k; i++) {
            children[i] += cookies[idx]; // give cookie
            solve(idx + 1, k, children, cookies); // exploring other sub-problems
            children[i] -= cookies[idx]; // take cookie (backtrack)
        }
    }
public:
    int distributeCookies(vector<int>& cookies, int k) {
       vector<int> children(k, 0);
       solve(0, k, children, cookies);
       return res; 
    }
};