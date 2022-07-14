class Solution {
public:
    bool isMatch(string s, string p) {
        vector<vector<bool>> dp(s.size()+1,vector<bool>(p.size()+1,0));
        for (int j=1;j<=p.size();j++) {
            if(p[j-1]!='*') break;
            dp[0][j]=true;
        }
        dp[0][0]=true;
        for (int i=1;i<=s.size();i++) {
            for (int j=1;j<=p.size();j++) {
                if (s[i-1]==p[j-1]||p[j-1]=='?') dp[i][j]=dp[i-1][j-1];
                else if (p[j-1]=='*') dp[i][j]=dp[i-1][j-1]||dp[i-1][j]||dp[i][j-1];
                else dp[i][j]=false;
            }
        }
        return dp[s.size()][p.size()];
    }
};

// class Solution {
// public:
//     bool f(int i,int j,string& s,string& p,vector<vector<int>>& dp) {
//         if (i<0) {
//             while (j>=0) {
//                 if(p[j]!='*') return false;
//                 j--;
//             }
//             return true;
//         }
//         if (j<0) return 0;
//         if (dp[i][j]!=-1) return dp[i][j];
        
//         if (s[i]==p[j]||p[j]=='?') return dp[i][j]=f(i-1,j-1,s,p,dp);
//         if (p[j]=='*') return dp[i][j]=f(i-1,j-1,s,p,dp)||f(i-1,j,s,p,dp)||f(i,j-1,s,p,dp);
//         return 0;
//     }
//     bool isMatch(string s, string p) {
//         vector<vector<int>> dp(s.size(),vector<int>(p.size(),-1));
//         return f(s.size()-1,p.size()-1,s,p,dp);
//     }
// };

// class Solution {
// public:
    
//     bool memo(int i, int j, string s, string p, vector<vector<int>> &dp) {
        
//         if(i < 0 && j < 0) return true;
//         if(i >= 0 && j < 0) return false;
//         if(i < 0 && j >= 0) {
//             for(int k = 0; k <= j; k++) {
//                 if(p[k] != '*') return false;
//             }
//             return true;
//         }
        
//         if(dp[i][j] != -1) return dp[i][j];
        
//         if(s[i] == p[j] || p[j] == '?') return dp[i][j] = memo(i - 1, j - 1, s, p, dp);
//         if(p[j] == '*') return dp[i][j] = memo(i - 1, j, s, p, dp) || memo(i, j - 1, s, p, dp);
//         return dp[i][j] = false;
//     }
    
//     bool isMatch(string s, string p) {
//         int n = s.size(), m = p.size();
//         vector<vector<int>> dp(n, vector<int>(m, -1));
//         return memo(n - 1, m - 1, s, p, dp);
//     }
// };