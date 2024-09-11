class Solution {
    public int minBitFlips(int start, int goal) {
        int count = 0;  // Initialize a counter to track the number of bit flips needed
        
        // XOR the start and goal numbers
        // XOR will give a 1 in each position where the bits of 'start' and 'goal' differ
        int xor = start ^ goal;

        // Loop through all bits of the XOR result
        while (xor != 0) {
            // Check the least significant bit (LSB)
            // `xor & 1` checks if the current bit is 1 (i.e., different between 'start' and 'goal')
            count += xor & 1;

            // Right shift xor by 1 to check the next bit
            // This moves the bits of 'xor' one position to the right
            xor >>= 1;
        }

        // Return the total number of different bits, which corresponds to the minimum number of bit flips
        return count;
    }
}
