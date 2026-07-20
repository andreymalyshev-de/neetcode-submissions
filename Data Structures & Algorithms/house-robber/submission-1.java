class Solution {
    public int rob(int[] nums) {
        int sum1 = nums[0];
        if (nums.length < 2) return sum1;
        int sum2 = Math.max(sum1, nums[1]);

        for (int i = 2; i < nums.length; i++) {
            int cur = nums[i];
            if (cur + sum1 > sum2) {
                int tmp = sum2;
                sum2 = cur + sum1;
                sum1 = tmp;
            }
            else {
                sum1 = sum2;
            }
        }

        return sum1 > sum2 ? sum1: sum2;
    }
}
