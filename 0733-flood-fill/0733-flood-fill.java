class Solution {
    // Dimensions of the image
    int n, m;

    // Depth First Search (DFS) helper function to perform flood fill
    private void dfs(int row, int col, int src, int color, int[][] image) {
        // Base cases:
        // 1. Out of bounds of the image
        // 2. Current pixel is not the source color (not part of the region to fill)
        // 3. Current pixel is already filled with the new color (avoid infinite recursion)
        if (row < 0 || row >= n || col < 0 || col >= m || image[row][col] != src || image[row][col] == color) {
            return;
        }

        // Update the current pixel to the new color
        image[row][col] = color;

        // Recur for all 4 neighboring directions
        dfs(row - 1, col, src, color, image); // Move Up
        dfs(row, col + 1, src, color, image); // Move Right
        dfs(row + 1, col, src, color, image); // Move Down
        dfs(row, col - 1, src, color, image); // Move Left
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // Initialize the dimensions of the image
        n = image.length;
        m = image[0].length;

        // Store the original color of the starting pixel
        int src = image[sr][sc];

        // If the starting pixel already has the new color, no need to proceed
        if (src != color) {
            dfs(sr, sc, src, color, image);
        }

        // Return the updated image
        return image;
    }
}
