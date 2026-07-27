

class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new ArrayDeque<>();
        int fresh = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 2) {
                    queue.offer(new int[]{row, col});
                } else if (grid[row][col] == 1) {
                    fresh++;
                }
            }
        }

        if (fresh == 0) {
            return 0;
        }

        int[][] directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        int minutes = 0;

        while (!queue.isEmpty() && fresh > 0) {
            int levelSize = queue.size();
            minutes++;

            for (int i = 0; i < levelSize; i++) {
                int[] current = queue.poll();
                int row = current[0];
                int col = current[1];

                for (int[] direction : directions) {
                    int nextRow = row + direction[0];
                    int nextCol = col + direction[1];

                    if (
                        nextRow >= 0 &&
                        nextRow < rows &&
                        nextCol >= 0 &&
                        nextCol < cols &&
                        grid[nextRow][nextCol] == 1
                    ) {
                        grid[nextRow][nextCol] = 2;
                        fresh--;
                        queue.offer(new int[]{nextRow, nextCol});
                    }
                }
            }
        }

        return fresh == 0 ? minutes : -1;
    }
}