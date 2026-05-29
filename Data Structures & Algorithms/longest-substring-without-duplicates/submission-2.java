class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int cur = 0;
        int cnt = 0;

        int i = 0;
        while (i < s.length()) {
            if (cnt > 3000) break;
            cnt++;
            char c = s.charAt(i);
            System.out.println("char: "+c);

            if (map.containsKey(c)) {
                cur = 0;
                i = map.get(c);
                map = new HashMap<>();
            }
            else {
                cur++;
                if (max < cur) max = cur;
                map.put(c, i);
            }
            System.out.println("i: "+i);
            i++;
        }
        return max;
    }
}
