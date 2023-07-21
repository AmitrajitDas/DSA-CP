class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        // transpose of matrix
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++) {
                int temp;
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        //reverse of matrix
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m/2; j++) {
                int temp;
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = temp;
            }
        }
    }
}