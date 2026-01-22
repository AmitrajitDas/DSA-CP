class Solution {
    Map<Long, Integer> dp = new HashMap<>();

    private int helper(long n) {
        if(n == 1) return 0;
        if(dp.containsKey(n)) return dp.get(n);
        
        int result;
        if(n % 2 == 0) {
            result = 1 + helper(n / 2);
        } else {
            if(n != 3 && ((n + 1) % 4) == 0) {
                result = 1 + helper(n + 1);
            } else {
                result = 1 + helper(n - 1);
            }
        }
        
        dp.put(n, result);
        return result;
    }
    public int integerReplacement(int n) {
        return helper((long) n);
    }
}