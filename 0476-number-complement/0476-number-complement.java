class Solution {
    public int findComplement(int num) {
        // Step 1: Calculate the bitmask
        int mask = (Integer.highestOneBit(num) << 1) - 1;
        
        // Step 2: XOR the number with the mask to get the complement
        return num ^ mask;
    }
}