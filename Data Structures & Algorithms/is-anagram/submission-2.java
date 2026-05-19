class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();

        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        for (char c : arr1) {
            if (map1.containsKey(c)) {
                int v = map1.get(c);
                map1.replace(c, (v + 1));
            } else {
                map1.put(c, 1);
            }
        }
        for (char c : arr2) {
            if (map2.containsKey(c)) {
                int v = map2.get(c);
                map2.replace(c, (v + 1));
            } else {
                map2.put(c, 1);
            }
        }
        for (char c : arr1) {
            if (!map2.containsKey(c))
                return false;
            if (!map1.get(c).equals(map2.get(c)))
                return false;
        }
        return true;
    }
}
