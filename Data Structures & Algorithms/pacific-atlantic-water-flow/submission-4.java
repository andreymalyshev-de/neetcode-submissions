class Solution {

    int cnt = 0;
    private int[][] visitedPac;
    private int[][] visitedAtl;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        visitedPac = new int[heights.length][heights[0].length];
        visitedAtl = new int[heights.length][heights[0].length];

        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[i].length; j++) {
                if (visitedPac[i][j] == -1 || visitedAtl[i][j] == -1) continue;
                if ((visitedPac[i][j] == 1 && visitedAtl[i][j] == 1) 
                || (helpPac(heights, i, j, Integer.MAX_VALUE) 
                && helpAtl(heights, i,j, Integer.MAX_VALUE))) {
                    System.out.println("pre: " + heights[i][j]);
                    List<Integer> list = new ArrayList<>();
                    list.add(i); list.add(j);
                    res.add(list);
                }
            }
        }
        return res;
    }

    private boolean helpPac(int[][] heights, int i, int j, int h) {
        //System.out.println("pac: " + heights[i][j] + " prev: " + h);
        if (i == -1 || j == -1) return true;
        if (i == heights.length || j == heights[i].length 
        || heights[i][j] > h || visitedPac[i][j] == -1) return false;
        if (visitedPac[i][j] == 1) return true;
        /*  cnt++;
        if (cnt > 100) return false;  */

        int n = heights[i][j];
        //System.out.println("PAC prev: "+ h + " cur: " + n);
        //System.out.println(i + " " + j);
        heights[i][j] = Integer.MAX_VALUE;
    

        if (helpPac(heights, i - 1, j, n)) {
            heights[i][j] = n;
            visitedPac[i][j] = 1;
            return true;
        }
        if (helpPac(heights, i, j - 1, n)) {
            heights[i][j] = n;
            visitedPac[i][j] = 1;
            return true;
        }
        if (helpPac(heights, i + 1, j, n)) {
            heights[i][j] = n;
            visitedPac[i][j] = 1;
            return true;
        }
        if (helpPac(heights, i, j + 1, n)) {
            heights[i][j] = n;
            visitedPac[i][j] = 1;
            return true;
        }

        heights[i][j] = n;
        visitedPac[i][j] = -1;
        return false;
    }

    private boolean helpAtl(int[][] heights, int i, int j, int h) {
        //System.out.println("atl: " + heights[i][j]);
        if (i == -1 || j == -1) return false;
        if (i == heights.length || j == heights[i].length) return true;
        if (heights[i][j] > h || visitedAtl[i][j] == -1) return false;
        if (visitedAtl[i][j] == 1) return true;
        /*  cnt++;
        if (cnt > 100) return false;  */

        int n = heights[i][j];
        //System.out.println("ATL prev: "+ h + " cur: " + n);
        //System.out.println(i + " " + j);
        heights[i][j] = Integer.MAX_VALUE;

        if (helpAtl(heights, i + 1, j, n)) {
            heights[i][j] = n;
            visitedAtl[i][j] = 1;
            return true;
        }
        if (helpAtl(heights, i, j + 1, n)) {
            heights[i][j] = n;
            visitedAtl[i][j] = 1;
            return true;
        }
        if (helpAtl(heights, i - 1, j, n)) {
            heights[i][j] = n;
            visitedAtl[i][j] = 1;
            return true;
        }
        if (helpAtl(heights, i, j - 1, n)) {
            heights[i][j] = n;
            visitedAtl[i][j] = 1;
            return true;
        }

        
        heights[i][j] = n;
        visitedAtl[i][j] = -1;
        return false;
    }
}
