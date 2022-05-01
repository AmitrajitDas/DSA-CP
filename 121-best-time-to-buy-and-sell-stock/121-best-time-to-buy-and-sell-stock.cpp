class Solution {
public:
    int maxProfit(vector<int>& prices) {
        
        int n = prices.size();
        int minPrice = INT_MAX, maxProfit = INT_MIN;
        
        for(int i = 0; i < n; i++) {
            minPrice = min(minPrice, prices[i]);
            maxProfit = max(maxProfit, prices[i] - minPrice);
        }
        
        return maxProfit;
    }
};