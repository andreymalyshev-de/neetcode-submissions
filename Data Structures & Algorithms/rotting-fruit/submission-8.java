class Solution {
    public int orangesRotting(int[][] grid) {
        int cnt = 0;

        Queue<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int n = grid[i][j];
                if (n == 2) {
                    q.offer(new int[]{i, j});
                }
            }
        }

        int size = q.size();
        while(!q.isEmpty()) {
            size--;
            int[] arr = q.poll();
            int i = arr[0];
            int j = arr[1];
            if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
                if (size == 0) {
                    size = q.size();
                    if (size != 0) cnt++;
                    //System.out.println(cnt + " size: " + size);
                }
                continue;
            }
            if (grid[i][j] == 0 || grid[i][j] == -1) {
                if (size == 0) {
                    size = q.size();
                    if (size != 0) cnt++;
                    //System.out.println(cnt + " size: " + size);
                }
                continue;
            }
            
            grid[i][j] = -1;
            q.offer(new int[]{i - 1, j});
            q.offer(new int[]{i, j - 1});
            q.offer(new int[]{i + 1, j});
            q.offer(new int[]{i, j + 1});
            if (size == 0) {
                size = q.size();
                if (size != 0) cnt++;
                //System.out.println(cnt + " size: " + size);
            }
        }
        if (cnt > 0) cnt--;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int n = grid[i][j];
                if (n == 1) {
                    return -1;
                }
            }
        }

        return cnt;
    }
}
