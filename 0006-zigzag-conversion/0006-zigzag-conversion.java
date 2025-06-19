class Solution {
    public String convert(String s, int numRows) {
        // Handle edge cases: single row or string shorter than numRows
        if(numRows == 1 || numRows >= s.length()) {
            return s;
        }
        
        // Create an array of lists to represent each row in the zigzag pattern
        List<Character>[] rowBucket = new ArrayList[numRows];
        for(int i = 0; i < numRows; i++) {
            rowBucket[i] = new ArrayList<>();
        }
        
        // Track current row index and direction of movement
        int idx = 0;      // Current row index (0 to numRows-1)
        int diff = 1;     // Direction: 1 for down, -1 for up
        
        // Process each character in the input string
        for(char ch : s.toCharArray()) {
            // Add current character to the current row
            rowBucket[idx].add(ch);
            
            // Change direction when reaching the boundaries
            if(idx == 0) {
                diff = 1;  // At top row, go down
            } else if(idx == numRows - 1) {
                diff = -1; // At bottom row, go up
            }
            
            // Move to next row based on current direction
            idx += diff;
        }
        
        // Build the result string by concatenating all rows
        StringBuilder res = new StringBuilder();
        for(List<Character> row : rowBucket) {
            for(char ch : row) {
                res.append(ch);
            }
        }
        
        return res.toString();
    }
}