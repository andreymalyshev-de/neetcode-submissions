class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int min = 101;
        for (int i: prices) {
            if (min > i) {
                min = i;
                continue;
            }
            max = Math.max(max, i - min);
        }
        return max;
    }
}
