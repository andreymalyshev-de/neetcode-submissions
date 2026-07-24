class Solution {
    public int climbStairs(int n) {
        int prev1 = 1;
        int cur = 1;

        for (int i = 1; i < n; i++) {
            int tmp = cur;
            cur += prev1;
            prev1 = tmp;
        }

        return cur;
    }
}
