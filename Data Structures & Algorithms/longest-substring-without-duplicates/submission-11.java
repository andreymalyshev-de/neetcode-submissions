class Solution {
    public int lengthOfLongestSubstring(String s) {
        // the same, but with a hashmap to jump directly to the repeated char

        int l = 0;
        int r = 0;
        int max = 0;
        HashMap<Character, Integer> set = new HashMap<>();

        while (r < s.length()) {
            if (set.containsKey(s.charAt(r))) {
                l = Math.max(l, set.get(s.charAt(r)) + 1);
                set.remove(s.charAt(r));
            }
            set.put(s.charAt(r), r);
            r++;
            max = Math.max(max, r - l);
            System.out.println("max: " + max + " l: " + l + " r: " + r);
        }

        return max;
    }
}
