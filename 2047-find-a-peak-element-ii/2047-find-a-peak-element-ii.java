class Solution {
    private int maxEle(int col, int[][] mat, int n) {
        int res = Integer.MIN_VALUE, row  = -1;
        for(int i = 0; i < n; i++) {
            if(mat[i][col] > res) {
                res = mat[i][col];
                row = i;
            }
        }
        return row;
    }

    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int low = 0, high = m - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            int row = maxEle(mid, mat, n);
            int left = mid - 1 >= 0 ? mat[row][mid - 1] : -1;
            int right = mid + 1 < m ? mat[row][mid + 1] : -1;
            int curr = mat[row][mid];
            if(curr > left && curr > right) {
                return new int[]{row, mid};
            } else if(curr < right) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return new int[]{-1, -1};
    }
} 