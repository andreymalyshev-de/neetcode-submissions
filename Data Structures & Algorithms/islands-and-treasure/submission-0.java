class Solution {
    public void islandsAndTreasure(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int n = grid[i][j];
                if (n == 0) {
                    if (i > 0) help(grid, 1, i - 1, j);
                    if (j > 0) help(grid, 1, i, j - 1);
                    if (j < grid[i].length - 1) help(grid, 1, i, j + 1);
                    if (i < grid.length - 1) help(grid, 1, i + 1, j);
                }
            }
        }
    }

    private void help(int[][] grid, int d, int i, int j) {
        int n = grid[i][j];
        if (n == 0 || n == -1) return;
        if (n < d) return;

        grid[i][j] = d;
        if (i > 0) help(grid, d + 1, i - 1, j);
        if (j > 0) help(grid, d + 1, i, j - 1);
        if (j < grid[i].length - 1) help(grid, d + 1, i, j + 1);
        if (i < grid.length - 1) help(grid, d + 1, i + 1, j);
    }
}
