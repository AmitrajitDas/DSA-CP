class Solution {
public:
    vector<int> successfulPairs(vector<int>& spells, vector<int>& potions, long long success) {
        int m = potions.size();
        sort(potions.begin(), potions.end());
        vector<int> res;

        for(auto spell : spells) {
            int start = 0, end = m - 1;
            int idx = m; // finding the weakest potion that works
            while(start <= end) {
                int mid = start + (end - start) / 2;
                long long product = (long long)spell * (long long)potions[mid];
                if(product  >= success) {
                    idx = mid;
                    end = mid - 1;
                } else start = mid + 1;
            }

            res.push_back(m - idx); // if idx is not changed then we push 0 ie no potion is found that works
        }

        return res;
    }
};