class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (map1.containsKey(s.charAt(i))) {
                int v = map1.get(s.charAt(i));
                map1.replace(s.charAt(i), (v + 1));
            } else {
                map1.put(s.charAt(i), 1);
            }
            if (map2.containsKey(t.charAt(i))) {
                int v = map2.get(t.charAt(i));
                map2.replace(t.charAt(i), (v + 1));
            } else {
                map2.put(t.charAt(i), 1);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (!map2.containsKey(s.charAt(i)))
                return false;
            if (!map1.get(s.charAt(i)).equals(map2.get(s.charAt(i))))
                return false;
        }
        return true;
    }
}
