class Solution {
    // Helper method to count number of 1's (set bits) in a number
    private int countSetBits(int num) {
        int count = 0;
        while(num != 0) {
            count += (num & 1);    // Add last bit to count
            num >>= 1;             // Right shift to check next bit
        }
        return count;
    }

    // Helper method to check if a specific bit position is set (1) or not
    private boolean isSet(int x, int bit) {
        return (x & (1 << bit)) != 0;  // Left shift 1 to bit position and AND
    }

    // Helper method to set a bit to 1 at given position
    private int setBit(int x, int bit) {
        return x | (1 << bit);     // OR operation with 1 at bit position
    }

    // Helper method to set a bit to 0 at given position
    private int unsetBit(int x, int bit) {
        return x & ~(1 << bit);    // AND with complement of 1 at bit position
    }

    // Main method to minimize XOR while maintaining set bit count
    public int minimizeXor(int num1, int num2) {
        int x = num1;
        // Count set bits in current number and target number
        int currSetBits = countSetBits(x);
        int reqSetBits = countSetBits(num2);
        
        // If both have same number of set bits, no modification needed
        if(currSetBits == reqSetBits) {
            return x;
        }
        
        int bit = 0;
        
        // If we need more set bits
        if(currSetBits < reqSetBits) {
            while(currSetBits < reqSetBits) {
                // Set bits from least significant positions if not already set
                if(!isSet(x, bit)) {
                    x = setBit(x, bit);
                    currSetBits++;
                }
                bit++;
            }
        } 
        // If we need fewer set bits
        else if(currSetBits > reqSetBits) {
            while(currSetBits > reqSetBits) {
                // Unset bits from least significant positions if set
                if(isSet(x, bit)) {
                    x = unsetBit(x, bit);
                    currSetBits--;
                }
                bit++;
            }
        }
        
        return x;
    }
}