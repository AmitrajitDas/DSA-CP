class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        int n = matrix.length, m = matrix[0].length;
        int left = 0, right = m - 1, top = 0, bottom = n - 1;

        // Traverse the matrix in a spiral order until all elements are added to the result list
        while (left <= right && top <= bottom) {
            // Traverse the top row from left to right
            for (int i = left; i <= right; i++)
                res.add(matrix[top][i]);
            top++;

            // Traverse the rightmost column from top to bottom
            for (int i = top; i <= bottom; i++)
                res.add(matrix[i][right]);
            right--;

            // Traverse the bottom row from right to left, if there is more than one row left
            if (top <= bottom) {
                for (int i = right; i >= left; i--)
                    res.add(matrix[bottom][i]);
                bottom--;
            }

            // Traverse the leftmost column from bottom to top, if there is more than one column left
            if (left <= right) {
                for (int i = bottom; i >= top; i--)
                    res.add(matrix[i][left]);
                left++;
            }
        }

        return res;
    }
}
