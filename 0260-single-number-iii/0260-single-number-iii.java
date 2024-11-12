class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0, rightmostSetbit = 0;
        for(final int num : nums) xor ^= num;

        rightmostSetbit = (xor & (xor - 1)) ^ xor;
        int b1 = 0, b2 = 0;

        for(final int num : nums) {
            if((num & rightmostSetbit) != 0) {
                b1 ^= num;
            } else {
                b2 ^= num;
            }
        }

        return new int[]{b1, b2};
    }
}