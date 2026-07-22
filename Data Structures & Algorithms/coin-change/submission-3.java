class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        //Array.sort(coins);
        int[] dp = new int[amount + 1];

        for (int i = 1; i < amount + 1; i++) {
            int sum = -1;
            for (int c: coins) {
                if (c == i) {
                    sum = 1;
                    break;
                }
                if (c > i) continue;
                if (dp[i - c] != -1) {
                    int tmp = dp[i - c] + 1;
                    if (tmp < sum || sum == -1) sum = tmp;
                }
            }
            if (i == 357 || i == 239 || i == 73 || i == 52 || i == 9832) System.out.println("i: " + i + " sum: " + sum);
            dp[i] = sum;
        }

        return dp[amount];
        
    }
}
