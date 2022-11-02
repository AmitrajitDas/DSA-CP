class Solution {
private:
    bool isValid(string a, string b) {
        if(a.length() != b.length()) return false;
        
        int count = 0;
        for(int i = 0; i < a.size(); i++) {
            if(a[i] != b[i]) count++;
        }
        
        return count == 1;
    }
public:
    int minMutation(string start, string end, vector<string>& bank) {
        if(bank.size() == 0) return -1;
        int n = bank.size(), m = bank[0].size();
        map<string, vector<string>> adj;
        
        for(int i = 0; i < n; i++) {        // connecting start genes with bank genes 
            if(isValid(start, bank[i])) {
                adj[start].push_back(bank[i]);
                adj[bank[i]].push_back(start);
            }
        }
        
        for(int i = 0; i < n - 1; i++) {   // connecting all the bank genes 
            for(int j = i + 1; j < n; j++) {
                if(isValid(bank[i], bank[j])) {
                    adj[bank[i]].push_back(bank[j]);
                    adj[bank[j]].push_back(bank[i]);
                }
            }
        }
        
        queue<string> q;
        set<string> st;
        q.push(start);
        st.insert(start);
        int res = 0;
        
        while(!q.empty()) {
            int size = q.size();
            
            for(int i = 0; i < size; i++) {
                auto node = q.front();
                q.pop();
                
                for(auto it : adj[node]) {
                    if(!st.count(it)) {
                        q.push(it);
                        st.insert(it); // set is used to ignore duplicate genes
                    }
                }
            }
            res++;
            if(st.count(end)) return res;
        }
        
        return -1;
    }
};