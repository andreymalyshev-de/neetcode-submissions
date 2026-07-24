class Solution {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        int prev1 = 1;
        int cur = 2;

        for (int i = 2; i < n; i++) {
            int tmp = cur;
            cur += prev1;
            prev1 = tmp;
        }

        return cur;
    }
}
