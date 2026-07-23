class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int cmax = nums[0];
        int cmin = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int n = nums[i];
            int tmp = cmax * n;
            cmax = Math.max(Math.max(cmax*n, cmin*n), n);
            cmin = Math.min(Math.min(cmin*n, tmp), n);
            max = Math.max(cmax, max);
        }

        return max;
    }
}
