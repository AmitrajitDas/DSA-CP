class Solution {
public:
    int subarraysDivByK(vector<int>& nums, int k) {
        int n = nums.size();
        vector<int> prefix;
        unordered_map<int, int> map;
        int count = 0;
        int sum = 0;
        int rem = 0;
        map[0] = 1;
        for(int it : nums) {
            sum += it;
            prefix.push_back(sum);
        }
        
        for(int it : prefix) {
            rem = it % k;
            if(rem < 0) rem += k;
            if(map.count(rem)) count += map[rem]; 
            map[rem]++;
        }
        
        return count;
    }
};