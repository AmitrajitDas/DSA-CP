class Solution {
    int n, m;
    private void dfs(int row, int col, int src, int color, int[][] image) {
        if(row < 0 || row >= n || col < 0 || col >= m || image[row][col] != src || image[row][col] == color) {
            return;
        }
        image[row][col] = color;
        dfs(row - 1, col, src, color, image);
        dfs(row, col + 1, src, color, image);
        dfs(row + 1, col, src, color, image);
        dfs(row, col - 1, src, color, image);
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        n = image.length;
        m = image[0].length;
        int src = image[sr][sc];
        dfs(sr, sc, src, color, image);

        return image;
    }
}