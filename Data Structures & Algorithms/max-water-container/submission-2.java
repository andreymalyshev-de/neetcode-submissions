class Solution {
    public int maxArea(int[] heights) {
        int max = 0;
        int i = 0;
        int j = heights.length - 1;

        while (i < j) {
            int sq = (j - i)*(Math.min(heights[i], heights[j]));
            if (sq > max) max = sq;

            if (heights[i] < heights[j]) i++;
            else j--;
        }

        return max;
    }
}
