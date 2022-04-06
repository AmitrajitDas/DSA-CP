class Solution {
public:
    int threeSumMulti(vector<int>& arr, int target) {
        unordered_map<int, long> map;
        for(int x : arr)
            map[x]++;
        long res = 0;
        for(auto itr1 : map) {
            for(auto itr2 : map) {
                int i = itr1.first, j = itr2.first;
                int k = target - i - j;
                if(!map.count(k)) // continue if element is not in hashmap
                    continue;
                
                // Cnk = n!/(n-k)!*k!
                if(i == j && j == k)
                    res += map[i] * (map[i] - 1) * (map[i] - 2) / 6;
                if(i == j && j != k)
                    res += map[i] * (map[i] - 1) / 2 * map[k];
                if(i < j && j < k)
                    res += map[i] * map[j] * map[k];
            }
        }
        
        return res % int(1e9 + 7);
    }
};