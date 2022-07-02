class Solution {
    int MOD = 1e9 + 7;
public:
    int maxArea(int h, int w, vector < int > & hCuts, vector < int > & vCuts) {
      sort(hCuts.begin(), hCuts.end());
      sort(vCuts.begin(), vCuts.end());
      int max_h = max(hCuts[0], h - hCuts.back());
      int max_v = max(vCuts[0], w - vCuts.back());
        
      for (int i = 0; i < hCuts.size() - 1; ++i)
        max_h = max(max_h, hCuts[i + 1] - hCuts[i]);
      for (int i = 0; i < vCuts.size() - 1; ++i)
        max_v = max(max_v, vCuts[i + 1] - vCuts[i]);
        
      return (long long) max_h * max_v % MOD;
    }
};