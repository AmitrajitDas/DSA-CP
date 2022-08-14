class Solution
{
public:
    void dfs(vector<vector<int>> &image, int src, int i, int j, int color)
    {
        if (i < 0 || i >= image.size() || j < 0 || j >= image[0].size() || image[i][j] != src || image[i][j] == color)
            return;

        image[i][j] = color;
        dfs(image, src, i - 1, j, color); // top
        dfs(image, src, i, j - 1, color); // left
        dfs(image, src, i, j + 1, color); // right
        dfs(image, src, i + 1, j, color); // down
    }

    vector<vector<int>> floodFill(vector<vector<int>> &image, int sr, int sc, int color)
    {
        int src = image[sr][sc];
        dfs(image, src, sr, sc, color);
        return image;
    }
};