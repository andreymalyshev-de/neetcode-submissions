class Solution {
    public int numIslands(char[][] grid) {
        int cnt = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    cnt++;
                    eliminate(grid, i, j);
                }
            }
        }

        return cnt;
    }

    public void eliminate(char[][] grid, int i, int j) {
        grid[i][j] = '0';
        
        if (i > 0 && grid[i - 1][j] == '1') eliminate(grid, i - 1, j);
        if (j > 0 && grid[i][j - 1] == '1') eliminate(grid, i, j - 1);
        if (j < grid[i].length - 1 && grid[i][j + 1] == '1') eliminate(grid, i, j + 1);
        if (i < grid.length - 1 && grid[i + 1][j] == '1') eliminate(grid, i + 1, j);
    }
}
