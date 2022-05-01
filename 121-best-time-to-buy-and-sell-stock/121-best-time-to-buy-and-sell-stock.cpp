class Solution {
public:
    int maxProfit(vector<int>& prices) {
        
        int n = prices.size();
        int min = INT_MAX, profit, maxProfit = INT_MIN;
        
        for(int i = 0; i < n; i++) {
            if(prices[i] < min)
                min = prices[i];
            
            profit = prices[i] - min;
            maxProfit = max(profit, maxProfit);
        }
        
        return maxProfit;
    }
};