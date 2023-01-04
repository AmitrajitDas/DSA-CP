class Solution {
public:
    int minimumRounds(vector<int>& tasks) {
        unordered_map<int, int> mp;
        for(auto &it : tasks) mp[it]++;
        
        int rounds = 0;
        for(auto &it : mp) {
            // freq = 2x + 3y
            int freq = it.second;
            if(freq == 1) return -1;
            if (freq % 3) rounds += freq/3 + 1;
            else rounds += freq/3;
        }

        return rounds;
    }
};