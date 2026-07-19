class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for (int i: piles) {
            max = Math.max(i, max);
        }

        int l = 1;
        int r = max;
        int min = max;
        while (l <= r) {
            int m = (l + r) / 2;
            int sum = 0;
            for (int i: piles) {
                sum += (int)Math.ceil((double)i / (double)m);
                if (sum > h) break;
            }
            if (sum > h) {
                l = m + 1;
            }
            else {
                r = m - 1;
                min = m;
            }
        }

        return min;
    }
}
