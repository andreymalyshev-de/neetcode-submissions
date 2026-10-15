class Solution {
    public String longestPalindrome(String s) {
        int max = 0;
        String str = "";

        int l = 0;
        int r = 1;
        while (r < s.length()) { //even
            int lt = l;
            int rt = r;
            while (l >= 0 && r < s.length() && s.charAt(l) == (s.charAt(r))) {
                if (max < (r - l + 1)) {
                    max = r - l + 1;
                    str = s.substring(l, r + 1);
                }
                l--;
                r++;
            }
            l = lt + 1;
            r = rt + 1;
        }

        l = 0;
        r = 0;
        while (r < s.length()) { //odd
            int lt = l;
            int rt = r;
            while (l >= 0 && r < s.length() && s.charAt(l) == (s.charAt(r))) {
                if (max < (r - l + 1)) {
                    max = r - l + 1;
                    str = s.substring(l, r + 1);
                }
                l--;
                r++;
            }
            l = lt + 1;
            r = rt + 1;
        }

        return str;
    }
}
