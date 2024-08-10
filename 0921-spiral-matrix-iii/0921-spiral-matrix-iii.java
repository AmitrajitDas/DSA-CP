class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        List<int[]> res = new ArrayList<>();
        boolean[][] vis = new boolean[rows][cols];
        int[] dRow = {0, 1, 0, -1}; // Directions: East, South, West, North
        int[] dCol = {1, 0, -1, 0};

        int currRow = rStart;
        int currCol = cStart;
        int dis = 0; // Initial direction: East
        int stepsInCurrDir = 0; // Steps taken in the current direction
        int steps = 1; // Initial step length

        while (res.size() < rows * cols) { // Ensure we visit all cells
            if (currRow >= 0 && currRow < rows && currCol >= 0 && currCol < cols && !vis[currRow][currCol]) {
                res.add(new int[]{currRow, currCol});
                vis[currRow][currCol] = true;
            }

            // Move to the next cell in the current direction
            currRow += dRow[dis];
            currCol += dCol[dis];
            stepsInCurrDir++;

            // Check if we need to change direction
            if (stepsInCurrDir == steps) {
                // Change direction
                dis = (dis + 1) % 4;
                stepsInCurrDir = 0; // Reset steps count for the new direction
                
                // Increase the step size after every two directions (East and West, South and North)
                if (dis % 2 == 0) {
                    steps++;
                }
            }

            // If moving out of bounds or to a visited cell, revert to last valid position
            // if (currRow < 0 || currRow >= rows || currCol < 0 || currCol >= cols || vis[currRow][currCol]) {
            //     // Move back to last valid cell
            //     currRow -= dRow[dis];
            //     currCol -= dCol[dis];
            //     stepsInCurrDir--; // One less step was valid in the previous direction
                
            //     // Change direction to previous one
            //     dis = (dis + 3) % 4; // Move to the previous direction
            //     currRow += dRow[dis];
            //     currCol += dCol[dis];
            //     stepsInCurrDir = 0; // Reset steps count for the new direction
                
            //     // Decrease step size if reverting from vertical direction (South or North)
            //     if (dis % 2 == 1) {
            //         steps--;
            //     }
            // }
        }

        return res.toArray(new int[res.size()][]);
    }
};