class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int s = help(grid, i, j);
                if (s > max) max = s;
            }
        }

        return max;
    }

    private int help(int[][] grid, int i, int j) {
        if (grid[i][j] == 0) return 0;

        grid[i][j] = 0;
        int s = 1;

        if (i > 0) s += help(grid, i - 1, j);
        if (j > 0) s += help(grid, i, j - 1);
        if (j < grid[i].length - 1) s += help(grid, i, j + 1);
        if (i < grid.length - 1) s += help(grid, i + 1, j);

        return s;
    }
}
