class Solution {
    Set<String> set;
    int[] dp;
    public boolean wordBreak(String s, List<String> wordDict) {
        // top down: start with the first and last char, then iteratively set the end to 
        // the left. if such word exists recursively check if the same applies for the
        // beginning after current end
        set = new HashSet<>(wordDict);
        dp = new int[s.length() + 1];
        dp[s.length()] = 1;
        return help(0, s.length(), s);
    }

    private boolean help(int begin, int end, String s) {
        if (dp[begin] == 1) return true;

        for (int i = end; i > begin; i--) {
            if (set.contains(s.substring(begin, i))) {
                if (dp[i] != -1 && (dp[i] == 1 || help(i, s.length(), s))) {
                    dp[begin] = 1;
                    return true;
                }
            }
        }

        dp[begin] = -1;
        return false;
    }
}
