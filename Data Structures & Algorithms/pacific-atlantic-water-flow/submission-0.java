
class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[i].length; j++) {
                if (
                    help1(
                        heights,
                        i,
                        j,
                        new boolean[heights.length][heights[0].length]
                    )
                    &&
                    help2(
                        heights,
                        i,
                        j,
                        new boolean[heights.length][heights[0].length]
                    )
                ) {
                    List<Integer> l = new ArrayList<>();
                    l.add(i);
                    l.add(j);
                    list.add(l);
                }
            }
        }

        return list;
    }

    public boolean help1(
        int[][] heights,
        int i,
        int j,
        boolean[][] visited
    ) {
        if (
            i < 0 ||
            i >= heights.length ||
            j < 0 ||
            j >= heights[0].length ||
            visited[i][j]
        ) {
            return false;
        }

        if (i == 0 || j == 0) {
            return true;
        } else {
            visited[i][j] = true;

            if (
                i - 1 >= 0 &&
                heights[i - 1][j] <= heights[i][j] &&
                help1(heights, i - 1, j, visited)
            ) {
                return true;
            }

            if (
                j - 1 >= 0 &&
                heights[i][j - 1] <= heights[i][j] &&
                help1(heights, i, j - 1, visited)
            ) {
                return true;
            }

            if (
                i + 1 < heights.length &&
                heights[i + 1][j] <= heights[i][j] &&
                help1(heights, i + 1, j, visited)
            ) {
                return true;
            }

            if (
                j + 1 < heights[0].length &&
                heights[i][j + 1] <= heights[i][j] &&
                help1(heights, i, j + 1, visited)
            ) {
                return true;
            }
        }

        return false;
    }

    public boolean help2(
        int[][] heights,
        int i,
        int j,
        boolean[][] visited
    ) {
        if (
            i < 0 ||
            i >= heights.length ||
            j < 0 ||
            j >= heights[0].length ||
            visited[i][j]
        ) {
            return false;
        }

        if (
            i == heights.length - 1 ||
            j == heights[0].length - 1
        ) {
            return true;
        } else {
            visited[i][j] = true;

            if (
                i - 1 >= 0 &&
                heights[i - 1][j] <= heights[i][j] &&
                help2(heights, i - 1, j, visited)
            ) {
                return true;
            }

            if (
                j - 1 >= 0 &&
                heights[i][j - 1] <= heights[i][j] &&
                help2(heights, i, j - 1, visited)
            ) {
                return true;
            }

            if (
                i + 1 < heights.length &&
                heights[i + 1][j] <= heights[i][j] &&
                help2(heights, i + 1, j, visited)
            ) {
                return true;
            }

            if (
                j + 1 < heights[0].length &&
                heights[i][j + 1] <= heights[i][j] &&
                help2(heights, i, j + 1, visited)
            ) {
                return true;
            }
        }

        return false;
    }
}
