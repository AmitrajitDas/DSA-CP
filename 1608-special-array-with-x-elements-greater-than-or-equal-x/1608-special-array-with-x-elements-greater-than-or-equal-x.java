class Solution {
    public int specialArray(int[] nums) {
        int n = nums.length;
        int[] freq = new int[n + 1];
        
        for(int num : nums) {
            freq[Math.min(num, n)]++;
        }

        int prefixSum = 0;
        for(int i = n; i >= 0; i--) {
            prefixSum += freq[i];
            if(i == prefixSum) {
                return i;
            }
        }

        return -1;
    }
}