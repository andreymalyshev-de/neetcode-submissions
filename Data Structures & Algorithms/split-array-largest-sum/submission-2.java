class Solution {
    public int splitArray(int[] nums, int k) {
        int max = 0;
        int sum = 0;
        for (int i: nums) {
            max = Math.max(i, max);
            sum += i;
        }
        
        int l = max;
        int r = sum;
        int cur_max = sum;
        int c = 0;

        while(l <= r) {
            int m = (l + r) / 2;
            int cur = 0;
            int left = k;
            for (int i: nums) {
                if (cur + i > m) {
                    cur = 0;
                    left--;
                    if (left == 0) break;
                }
                cur += i;
            }
            if (left == 0) l = m + 1;
            else {
                cur_max = m;
                r = m - 1;
            }
        }

        return cur_max;
    }
}