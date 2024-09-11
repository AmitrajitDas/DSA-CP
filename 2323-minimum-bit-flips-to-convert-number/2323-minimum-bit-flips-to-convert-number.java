class Solution {
    public int minBitFlips(int start, int goal) {
        int count = 0;
        int xor = start ^ goal;

        while(xor != 0) {
            count += xor & 1;
            xor >>= 1;
        }
        
        return count;
    }
}