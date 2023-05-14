// TC: O(N), SC: O(1)
class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int minPrice = prices[0], maxProfit = INT_MIN;
        for(int i = 0; i < prices.size(); i++) {
            minPrice = min(minPrice, prices[i]); // finding the minimum price to get the max profit
            maxProfit = max(maxProfit, prices[i] - minPrice); // maximizing profit
           
        }

        return maxProfit;
    }
};