class Solution {
    public int characterReplacement(String s, int k) {
        // sliding window
        //Given this window, how many replacements would be required, so that it becomes
        //filled with a single char?

        int l = 0;
        int r = 0;
        int max = 0;
        int maxFreq = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        while(r < s.length()) {
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(s.charAt(r)));
            System.out.println(s.charAt(r));
            System.out.println("maxFreq: " + maxFreq + " sum: " + (r - l + 1 - maxFreq));
            while (r - l + 1 - maxFreq > k) {
                map.replace(s.charAt(l), map.get(s.charAt(l)) - 1);
                l++;
            }
            max = Math.max(max, r - l + 1);
            r++;
        }

        return max;
    }
}
