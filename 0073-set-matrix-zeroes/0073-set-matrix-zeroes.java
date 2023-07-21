class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        boolean col0 = true;
        // mark 1st row & 1st col as 0 when found 0 in the inner matrix
        for(int i = 0; i < n; i++) {
            if(matrix[i][0] == 0) col0 = false; // if 1st col has 0 then we set col0 as false
            for(int j = 1; j < m; j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // marking inner matrix with 0 if 1st row or col is 0
        for(int i = n - 1; i >= 0; i--) {
            for(int j = m - 1; j >= 1; j--) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;
            }
            if(!col0) matrix[i][0] = 0; // if col0 is false
        }
    }
}