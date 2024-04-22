class Solution {
    private int[] dfs(int i, int j, int row, int col, int[][] land) {
        int[] coords = new int[4];
        coords[0] = i;
        coords[1] = j;

        int r = i, c = j;

        while (r < row && land[r][j] == 1)
            r++;
        while (c < col && land[i][c] == 1)
            c++;

        coords[2] = r - 1;
        coords[3] = c - 1;

        for (int k = i; k < r; k++) {
            for (int l = j; l < c; l++) {
                land[k][l] = 0;
            }
        }

        return coords;

    }

    public int[][] findFarmland(int[][] land) {
        int n = land.length, m = land[0].length;
        List<int[]> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (land[i][j] == 1) {
                    int[] coords = dfs(i, j, n, m, land);
                    res.add(coords);
                }
            }
        }

        return res.toArray(new int[res.size()][]);
    }
}