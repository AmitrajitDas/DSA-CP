class Solution {

    public List<String> generateParenthesis(int n) {
        // dp[i] stores all valid combinations for i pairs of parentheses
        List<List<String>> dp = new ArrayList<>();
        
        // Base case: 0 pairs = empty string
        dp.add(Arrays.asList(""));
        
        // Build up from 1 to n pairs
        for (int i = 1; i <= n; i++) {
            List<String> current = new ArrayList<>();
            
            // For each way to split i pairs into left and right parts
            for (int left = 0; left < i; left++) {
                int right = i - 1 - left;
                
                // Combine all possibilities from left and right parts
                for (String leftPart : dp.get(left)) {
                    for (String rightPart : dp.get(right)) {
                        current.add("(" + leftPart + ")" + rightPart);
                    }
                }
            }
            
            dp.add(current);
        }
        
        return dp.get(n);
    }
}
