class Solution {
public:
    int maxProfit(vector<int>& prices) {
        
        int n = prices.size();
        int minPrice = prices[0], maxProfit = INT_MIN;
        
        for(int i = 0; i < n; i++) {
            maxProfit = max(maxProfit, prices[i] - minPrice);
            minPrice = min(minPrice, prices[i]);
        }
        
        return maxProfit;
    }
};
