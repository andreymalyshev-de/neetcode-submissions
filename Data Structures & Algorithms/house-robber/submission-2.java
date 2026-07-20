class Solution {
    public int rob(int[] nums) {
        int sum1 = 0;
        int sum2 = 0;

        for (int i = 0; i < nums.length; i++) {
            int tmp = Math.max(nums[i] + sum1, sum2);
            sum1 = sum2;
            sum2 = tmp;
        }

        return sum1 > sum2 ? sum1: sum2;
    }
}
