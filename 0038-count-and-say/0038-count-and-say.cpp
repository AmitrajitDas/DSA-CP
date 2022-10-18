class Solution {
public:
    string countAndSay(int n) {
        if (!n) return "";
        string res = "1";
        while(--n) {
            string curr = "";
            int N = res.size();
            for(int i = 0; i < N; i++) {
                int count = 1;
                while(i + 1 < N && res[i] == res[i + 1]) {
                    count++;
                    i++;
                }
                
                curr += to_string(count) + res[i];
            }
            
            res = curr;
        }
        
        return res;
    }
};