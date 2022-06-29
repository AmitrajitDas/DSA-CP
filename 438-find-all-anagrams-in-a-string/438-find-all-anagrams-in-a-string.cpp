class Solution {
public:
    vector<int> findAnagrams(string s, string p) {
        unordered_map<char, int> map;
        for(char c : p) map[c]++;
        int count = map.size();
        int i = 0, j =0, k = p.size();
        vector<int> res;
        
        while(j < s.size()) {
            if(map.find(s[j]) != map.end()) {
                map[s[j]]--;
                if(map[s[j]] == 0) count--;
            }
            
            if(j - i + 1 < k) j++;
            else if(j - i + 1 == k) {
                if(count == 0) res.push_back(i);
                if (map.find(s[i]) != map.end()){
                    map[s[i]]++;
                    if (map[s[i]] == 1){
                        count++;
                    }
                }
                i++;
                j++;  
            }
        }
        
        return res;
    }
};