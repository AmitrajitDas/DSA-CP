class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] result = new int[n];
        
        // Variables for left to right pass
        int countLeft = 0;  // counts balls seen from left
        int movesLeft = 0;  // accumulates moves needed from left
        
        // First pass: Left to Right
        for(int i = 0; i < n; i++) {
            result[i] += movesLeft;  // add current moves needed from left
            
            // If current position has a ball
            if(boxes.charAt(i) == '1') {
                countLeft++;  // increment count of balls seen
            }
            
            // Update moves needed for next position
            // All previous balls need one more move
            movesLeft += countLeft;
        }
        
        // Variables for right to left pass
        int countRight = 0;  // counts balls seen from right
        int movesRight = 0;  // accumulates moves needed from right
        
        // Second pass: Right to Left
        for(int i = n-1; i >= 0; i--) {
            result[i] += movesRight;  // add current moves needed from right
            
            // If current position has a ball
            if(boxes.charAt(i) == '1') {
                countRight++;  // increment count of balls seen
            }
            
            // Update moves needed for next position
            // All previous balls need one more move
            movesRight += countRight;
        }
        
        return result;
    }
}