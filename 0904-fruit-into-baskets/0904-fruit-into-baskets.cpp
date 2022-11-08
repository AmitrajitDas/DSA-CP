/////// Same Approach as Longest K unique characters substring /////////

class Solution {
public:
    int totalFruit(vector<int>& fruits) {
        int i = 0, j = 0, n = fruits.size();
        unordered_map<int, int> mp;
        int res = 1;
        
        while(j < n) {
            mp[fruits[j]]++;
            while(mp.size() > 2) {
                mp[fruits[i]]--;
                if(mp[fruits[i]] == 0) mp.erase(fruits[i]);
                i++;
            }
            if(mp.size() <= 2) res = max(j - i + 1, res);
            j++;
        }
        
        return res;
    }
};