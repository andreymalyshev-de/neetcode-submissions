class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) return false;
        
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        
        for (int i = 0; i < s1.length(); i++) {
            map1.put(s1.charAt(i), map1.getOrDefault(s1.charAt(i), 0) + 1);
        }

        int l = 0;
        int r = 0;

        while (r - l < s1.length()) {
            map2.put(s2.charAt(r), map2.getOrDefault(s2.charAt(r), 0) + 1);
            r++;
        }

        if (map1.equals(map2)) return true;
        
        while (r < s2.length()) {
            System.out.println(s2.charAt(l));

            System.out.println("Map 1 keys: " + map1.keySet());
            System.out.println("Map 2 keys: " + map2.keySet());
            int g = map2.get(s2.charAt(l));
            if (g == 1) {
                map2.remove(s2.charAt(l));
            }
            else {
                map2.replace(s2.charAt(l), map2.get(s2.charAt(l)) - 1);
            }
            l++;

            map2.put(s2.charAt(r), map2.getOrDefault(s2.charAt(r), 0) + 1);
            r++;

            if (map1.equals(map2)) return true;
        }

        return false;

    }
}
