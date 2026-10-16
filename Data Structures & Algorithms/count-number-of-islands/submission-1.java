class Solution {
    public int numIslands(char[][] grid) {
        int cnt = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                char c = grid[i][j];
                if (c == '1') {
                    cnt++;
                    help(grid, i, j);
                }
            } 
        }

        return cnt;
    }

    private void help(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length) return; 
        if (grid[i][j] == '-' || grid[i][j] == '0') return;

        grid[i][j] = '-';
        help(grid, i - 1, j);
        help(grid, i, j - 1);
        help(grid, i + 1, j);
        help(grid, i, j + 1);
    }
}
