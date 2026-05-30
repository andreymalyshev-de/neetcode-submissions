class Solution {
    public int lengthOfLongestSubstring(String s) {
        // slidin' window:
        // left pointer goes right and shrinks the window
        // right pointer goes right and widens it

        int l = 0;
        int r = 0;
        int max = 0;
        Set<Character> set = new HashSet<>();

        while (r < s.length()) {
            while (set.contains(s.charAt(r))) {
                set.remove(s.charAt(l));
                l++;
            }
            set.add(s.charAt(r));
            r++;
            max = Math.max(max, set.size());
        }

        return max;
    }
}
