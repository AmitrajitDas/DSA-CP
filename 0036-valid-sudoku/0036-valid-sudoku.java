class Solution {
    public boolean isValidSudoku(char[][] board) {

        // Create sets to track seen numbers for each row, column, and 3x3 box
        Set<Character>[] rows = new HashSet[9];
        Set<Character>[] cols = new HashSet[9];
        Set<Character>[] boxes = new HashSet[9];
        
        // Initialize all sets
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                
                // Skip empty cells
                if (num == '.') {
                    continue;
                }
                
                // Calculate which 3x3 box this cell belongs to
                int boxIndex = (i / 3) * 3 + (j / 3);
                
                // Check if number already exists in row, column, or box
                if (rows[i].contains(num) || 
                    cols[j].contains(num) || 
                    boxes[boxIndex].contains(num)) {
                    return false;
                }
                
                // Add number to respective sets
                rows[i].add(num);
                cols[j].add(num);
                boxes[boxIndex].add(num);
            }
        }

        return true;
    }
}