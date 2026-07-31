class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) q.add(new int[]{i, j, 0});
            }
        }

        while (!q.isEmpty()) {
            int i = q.peek()[0];
            int j = q.peek()[1];
            int cnt = q.poll()[2];
            int n = grid[i][j];
            //System.out.println(n + " " + cnt);
            if (n != 0 || (n == 0 && cnt > n)) {if (n == -1 || n <= cnt) continue;}
            grid[i][j] = cnt;

                if (i > 0) q.add(new int[]{i - 1, j, cnt + 1});
                if (j > 0) q.add(new int[]{i, j - 1, cnt + 1});
                if (i < grid.length - 1) q.add(new int[]{i + 1, j, cnt + 1});
                if (j < grid[i].length - 1) q.add(new int[]{i, j + 1, cnt + 1});
        }
    }
}
