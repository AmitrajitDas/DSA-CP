class Solution {
    public int numSteps(String s) {
        int n = s.length(), carry = 0, steps = 0;

        // Iterate from the least significant bit (rightmost) to just before the leading '1'
        for(int i = n - 1; i > 0; i--) {
            int bit = Character.getNumericValue(s.charAt(i)) + carry;

            if(bit == 0) {
                // Bit is 0 (no carry): just divide by 2 (right shift) → 1 step
                carry = 0;
                steps++;
            } else if(bit == 2) {
                // Bit is 1 with an incoming carry → results in 0, carry the 1 forward
                // The addition made it even, so we divide by 2 → 1 step (carry persists)
                carry = 1;
                steps++;
            } else {
                // Bit is 1 (no carry): must add 1 to make it even, then divide by 2 → 2 steps
                // Adding 1 creates a carry for the next bit
                carry = 1;
                steps += 2;
            }
        }

        // If a carry remains after processing all bits, it needs one final addition step
        // (the leading bit '1' plus carry '1' = '10', which adds one more step)
        if(carry == 1) steps++;

        return steps;
    }
}