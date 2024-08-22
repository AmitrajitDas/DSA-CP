class Solution {
    public int bitwiseComplement(int n) {
        if(n == 0) return 1;
        // Step 1: Calculate the bitmask
        int mask = (Integer.highestOneBit(n) << 1) - 1;
        
        // Step 2: XOR the number with the mask to get the complement
        return n ^ mask;
    }
}