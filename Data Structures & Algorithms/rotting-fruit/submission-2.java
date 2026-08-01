class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) q.add(new int[]{i, j, 0});
            }
        }

        int mins = 0;

        while(!q.isEmpty()) {
            int[] el = q.poll();
            int i = el[0];
            int j = el[1];
            int cnt = el[2];
            int n = grid[i][j];
            if (n == 0 || (n == 2 && cnt != 0)) continue;
            System.out.println(i + " " + j + " " + cnt);

            grid[i][j] = 2;
            mins = Math.max(mins, cnt + 1);

            if (i > 0) q.add(new int[]{i - 1, j, cnt + 1});
            if (j > 0) q.add(new int[]{i, j - 1, cnt + 1});
            if (i < grid.length - 1) q.add(new int[]{i + 1, j, cnt + 1});
            if (j < grid[i].length - 1) q.add(new int[]{i, j + 1, cnt + 1});
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) return -1;
            }
        }

        return Math.max(0, mins - 1);
    }
}
