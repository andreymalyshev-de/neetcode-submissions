class Solution {
    public int numDecodings(String s) {
        int prev1 = 1;
        int prev2 = 0;
        int cur = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '0') {
                cur += prev1;
                if (i > 0 && (s.charAt(i - 1) == '1' || 
                (s.charAt(i - 1) == '2' && s.charAt(i) < '7'))) {
                    cur += prev2;
                }
            }
            else {
                cur = prev2; // one step back
                if (i == 0 || s.charAt(i - 1) == '0' || s.charAt(i - 1) >= '3') return 0;
            }
            prev2 = prev1;
            prev1 = cur;
            cur = 0;
        }
        return prev1;
    }
}
