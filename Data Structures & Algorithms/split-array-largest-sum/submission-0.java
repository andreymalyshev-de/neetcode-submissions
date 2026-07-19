class Solution {
    public int splitArray(int[] nums, int k) {
        int max = 0;
        for (int i: nums) {
            max = Math.max(i, max);
        }
        
        while(true) {
            int cur = 0;
            int cur_max = 0;
            int left = k;
            for (int i: nums) {
                if (i + cur > max) {
                    cur = i;
                    cur_max = Math.max(cur, cur_max);
                    left--;
                    if (left == 0) break;
                }
                else {
                    cur += i;
                    cur_max = Math.max(cur, cur_max);
                }
            }
            if (left == 0) {
                max++;
                continue;
            }
            else return cur_max;
        }
    }
}