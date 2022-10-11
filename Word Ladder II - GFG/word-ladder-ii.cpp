//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;


// } Driver Code Ends
//User function Template for C++

class Solution {
public:
    vector<vector<string>> findSequences(string beginWord, string endWord, vector<string>& wordList) {
        int n = wordList.size();
        vector<vector<string>> res;
		unordered_set<string> st(wordList.begin(), wordList.end());
		queue<vector<string>> q;
		q.push({beginWord});
		st.erase(beginWord);
        vector<string> vis;
        int level = 0;
        
        while(!q.empty()) {
            vector<string> v = q.front();        
            q.pop();
             
            // erasing all words thats been used in prev levels
            if(v.size() > level) {
                level++;
                for(auto it : vis) st.erase(it);
            }
            
            string word = v.back();
            if(word == endWord) {
                // for the first vector or other vectors with same size
                if(!res.size() || res[0].size() == v.size()) res.push_back(v);
            }
            
            for (int i = 0; i < word.size(); i++) {
				char original = word[i];
				for (char c = 'a'; c <= 'z'; c++) {
					word[i] = c;
					auto it = st.find(word);
					if (it != st.end()) {
						v.push_back(word);
                        q.push(v);
                        vis.push_back(word);
                        v.pop_back(); // to reuse v in same level
					}
				}

				word[i] = original;
			}
        }
        
        return res;
    }
};

//{ Driver Code Starts.

bool comp(vector<string> a, vector<string> b)
{
    string x = "", y = "";
    for(string i: a)
        x += i;
    for(string i: b)
        y += i;
    
    return x<y;
}

int main(){
	int tc;
	cin >> tc;
	while(tc--){
		int n;
		cin >> n;
		vector<string>wordList(n);
		for(int i = 0; i < n; i++)cin >> wordList[i];
		string startWord, targetWord;
		cin >> startWord >> targetWord;
		Solution obj;
		vector<vector<string>> ans = obj.findSequences(startWord, targetWord, wordList);
		if(ans.size()==0)
		    cout<<-1<<endl;
		else
		{
		    sort(ans.begin(), ans.end(), comp);
            for(int i=0; i<ans.size(); i++)
            {
                for(int j=0; j<ans[i].size(); j++)
                {
                    cout<<ans[i][j]<<" ";
                }
                cout<<endl;
            }
		}
	}
	return 0;
}
// } Driver Code Ends