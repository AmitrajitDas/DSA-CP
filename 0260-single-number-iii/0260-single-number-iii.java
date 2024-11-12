class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0, rightmostSetbit = 0;

        // Perform XOR of all elements in the array. 
        // This results in XOR of the two unique elements (all other elements cancel out).
        for(final int num : nums) {
            xor ^= num;
        }

        // Isolate the rightmost set bit in the XOR result.
        // This bit is different between the two unique elements.
        rightmostSetbit = (xor & (xor - 1)) ^ xor;

        int b1 = 0, b2 = 0;

        // Divide the numbers into two groups based on the isolated bit
        // and XOR each group separately to get the two unique elements.
        for(final int num : nums) {
            if((num & rightmostSetbit) != 0) {
                b1 ^= num; // XOR of first group
            } else {
                b2 ^= num; // XOR of second group
            }
        }

        // Return the two unique numbers found
        return new int[]{b1, b2};
    }
}