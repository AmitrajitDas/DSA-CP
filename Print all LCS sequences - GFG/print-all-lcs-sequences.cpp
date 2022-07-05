// { Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
class Solution
{
    vector<string> res;
    string sub;
    set<string> lexiSet;
    
	public:
		  int tabulation(string &s, string &t) {
		    
		    int n = s.size();
		    int m = t.size();
		    vector<vector<int>> dp(n + 1, vector<int> (m + 1, 0));
              
            for (int i = 0; i <= n; i++) {
                dp[i][0] = 0;
            }
            
            for (int i = 0; i <= m; i++) {
                dp[0][i] = 0;
            }
            
            for (int ind1 = 1; ind1 <= n; ind1++) {
                for (int ind2 = 1; ind2 <= m; ind2++) {
                    if (s[ind1 - 1] == t[ind2 - 1])
                        dp[ind1][ind2] = 1 + dp[ind1 - 1][ind2 - 1];
                    else
                        dp[ind1][ind2] = 0 + max(dp[ind1 - 1][ind2], dp[ind1][ind2 - 1]);
                }
            }
	
	        return dp[n][m];
		}
		
		void backtrack(string &s, string &t, int ind1, int ind2, int count) {
		    
		    if(count == 0) {
		        string ans = sub;
		        
		        if(!lexiSet.count(ans)) {
		            lexiSet.insert(ans);
		            res.push_back(ans);
		        }
		        
		        return;
		    }
		    
		    for(int i = ind1; i < s.size(); i++) {
		        for(int j = ind2; j < t.size(); j++) {
		            
		            if(s[i] == t[j]) {
		                sub += s[i];
		                backtrack(s ,t, i + 1, j + 1, count - 1);
		                sub.pop_back();
		            }
		        }
		    }
		}
		
		vector<string> all_longest_common_subsequences(string s, string t) {
		    
		    int n = s.size(), m = t.size();
		    
		    int count = tabulation(s, t);
		    
		    backtrack(s, t, 0, 0, count);
		    
		    sort(res.begin(), res.end());
		    
		    return res;
		}
	    
};



// { Driver Code Starts.
int main(){
    int T;
    cin >> T;
    while(T--)
    {
    	string s, t;
    	cin >> s >> t;
    	Solution ob;
    	vector<string> ans = ob.all_longest_common_subsequences(s, t);
    	for(auto i: ans)
    		cout << i << " ";
    	cout << "\n";
    }
	return 0;
}

  // } Driver Code Ends