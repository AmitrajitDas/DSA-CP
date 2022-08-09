class Solution {
public:
    int MOD = 1e9 + 7;
    int numFactoredBinaryTrees(vector<int>& arr) {
        sort(arr.begin(), arr.end());
        unordered_map<int, long> mp;
        mp[arr[0]] = 1;
        long count = 1;
        
        for(int i = 1; i < arr.size(); i++) {
            count = 1;
            for(auto it : mp) {
                if(arr[i] % it.first == 0 && mp.find(arr[i]/it.first) != mp.end())
                    count += it.second * mp[arr[i]/it.first];
            }
            
            mp[arr[i]] = count;
        }
        
        long sum = 0;
        for(auto it : mp) sum = (sum + it.second) % MOD;
        
        return (int) sum;
    }
};