class Solution {
    public void rotate(int[][] matrix) {
        
        int n = matrix.length;
        
        // transpose
        
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < i; j++)
            {
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        // reverse
        
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n/2; j++)
            {
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - j - 1];
                matrix[i][matrix.length - j - 1] = temp;
            }
        }
    }
}