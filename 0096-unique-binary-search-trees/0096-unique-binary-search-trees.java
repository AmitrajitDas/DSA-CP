class Solution {
    public int numTrees(int n) {
        if(n <= 1) return 1;
        int res = 0;
        for(int i = 1; i <= n; i++) {
            res += numTrees(i - 1) * numTrees(n - i);
        }
        return res;
    }
}