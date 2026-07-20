class Solution {
    public String longestPalindrome(String s) {
        int l = 0;
        int r = 1;
        String str = s.substring(0, 1);

        while (r < s.length()) {
            if (s.charAt(l) == s.charAt(r)) {
                if (str.length() < r - l + 1) str = s.substring(l, r + 1);
                if (l > 0 && r < s.length() - 1) {
                    l--;
                    r++;
                }
                else {
                    if ((r - l + 1) % 2 == 0 && l > 0) l--;
                    else { 
                        l = (r + l) / 2;
                        l++;
                        r = l + 1;
                    }
                }
            }
            else if (r - l + 1 == 2 && l > 0) l--;
            else {
                l = (r + l) / 2;
                l++;
                r = l + 1;
            }
        }

        return str;
    }

    private boolean isPal(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l <= r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            r--;
            l++;
        }
        return true;
    }
}
