class Solution {
public:
    int change(int amount, vector<int>& coins) 
    {
        int n = coins.size();
        vector<long> prev(amount + 1, 0);
        
        for(int target = 0; target <= amount; target++)
        {
            if(target % coins[0] == 0) prev[target] = 1;
        }
        
        for(int idx = 1; idx < n; idx++)
        {
            vector<long> curr(amount + 1, 0);
            for(int target = 0; target <= amount; target++)
            {
                long notTake = prev[target];
                long take = 0;
                if(coins[idx] <= target)
                    take = curr[target - coins[idx]];
                
                curr[target] = notTake + take;
            }
            
            prev = curr;
        }
        
        return prev[amount];
    }
};