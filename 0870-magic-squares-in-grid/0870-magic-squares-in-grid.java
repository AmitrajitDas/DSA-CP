class Solution {
    private boolean isMagicSquare(int row, int col, int[][] grid) {
        boolean[] vis = new boolean[10];
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                int num = grid[row + i][col + j];
                if(num < 1 || num > 9 || vis[num]) {
                    return false;
                } else {
                    vis[num] = true;
                }
            }
        }

        int targetSum = grid[row][col] + grid[row][col + 1] + grid[row][col + 2];

        for(int i = 0; i < 3; i++) {
            int sum = grid[row + i][col] + grid[row + i][col + 1] + grid[row + i][col + 2];
            if(sum != targetSum) {
                return false;
            }
        }

        for(int j = 0; j < 3; j++) {
            int sum = grid[row][col + j] + grid[row + 1][col + j] + grid[row + 2][col + j];
            if(sum != targetSum) {
                return false;
            }
        }

        int firstDiagSum = grid[row][col] + grid[row + 1][col + 1] + grid[row + 2][col + 2];
        int secondDiagSum = grid[row][col + 2] + grid[row + 1][col + 1] + grid[row + 2][col];

        if(firstDiagSum != targetSum || secondDiagSum != targetSum) {
            return false;
        }

        return true;
    }

    public int numMagicSquaresInside(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;

        for(int i = 0; i <= n - 3; i++) {
            for(int j = 0; j <= m - 3; j++) {
                if(isMagicSquare(i, j, grid)) {
                    count++;
                }
            }
        }

        return count;
    }
};