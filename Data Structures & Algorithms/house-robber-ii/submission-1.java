class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int sum1 = 0;
        int sum2 = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            int tmp = Math.max(nums[i] + sum1, sum2);
            sum1 = sum2;
            sum2 = tmp;
        }

        int max = Math.max(sum1, sum2);
        sum1 = 0;
        sum2 = 0;

        for (int i = 1; i < nums.length; i++) {
            int tmp = Math.max(nums[i] + sum1, sum2);
            sum1 = sum2;
            sum2 = tmp;
        }

        max = Math.max(max, Math.max(sum1, sum2));

        return max;
    }
}
