class Solution {
    public String minWindow(String s, String t) {

        if (t.length() > s.length() || t == "") return "";
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        for (char c: t.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
            map2.put(c, 0);
        }

        int matches = 0;
        int l = 0;
        int r = 0;
        int min = 1001;
        int[] mini = new int[]{-1, -1};
        int cnt = 0;

        while (r < s.length()) {
        
            System.out.println("l: " + l + " r: " + r);
            System.out.println("matches: " + matches);

            char c = s.charAt(r);
            if (map1.containsKey(c)) {
                map2.put(c, map2.getOrDefault(c, 0) + 1);
                if (map2.get(c) == map1.get(c)) matches++;
            }            

            while (matches == map1.size()) {
                if (r - l + 1 < min) {
                    min = r - l + 1;
                    mini[0] = l;
                    mini[1] = r + 1;
                }
                c = s.charAt(l);
                if (map1.containsKey(c)) {
                    map2.put(c, map2.get(c) - 1);
                     if (map2.get(c) < map1.get(c)) matches--;
                }
                l++;
            }

            r++;
        }
        return min == 1001 ? "" : s.substring(mini[0], mini[1]);
    }
}
