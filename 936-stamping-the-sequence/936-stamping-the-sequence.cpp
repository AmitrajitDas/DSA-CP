class Solution {
public:
    
    bool canMark(string &stamp, string &target, int pos) {
        for(int i = 0; i < stamp.length(); i++) {
            if(target[pos + i] != '?' && target[pos + i] != stamp[i]) return false;
        }
        
        return true;
    }
    
    bool mark(string &stamp, string &target, int pos, int &marks) {
        for(int i = 0; i < stamp.length(); i++) {
            if(target[pos + i] != '?') {
                target[pos + i] = '?';
                marks++;
            }
        }
        
        return marks;
    }
    
    vector<int> movesToStamp(string stamp, string target) {
        vector<int> res;
        int n = target.length(), m = stamp.length();
        vector<bool> vis(n, false);
        int marks = 0;
        
        while(marks < n) {
            bool doneMarking = false;
            for(int i = 0; i <= n - m; i++) {
                if(!vis[i] && canMark(stamp, target, i)) {
                    mark(stamp, target, i, marks);
                    vis[i] = true;
                    doneMarking = true;
                    res.push_back(i);
                    
                    if(marks == n) break;
                }
            }
            
            if(!doneMarking) {
                vector<int> v;
                return v;
            }
        }
        
        reverse(res.begin(), res.end());
        return res;
    }
};