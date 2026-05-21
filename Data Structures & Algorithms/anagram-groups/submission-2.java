class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // just one array iteration -> direct check of the anagramness with the hashmap into which i put the strings     
        HashMap<String, List<String>> map = new HashMap<>();

        for (String s: strs) {
            Set<String> set = map.keySet();
            Iterator<String> it = set.iterator(); // starts without any element assigned
            boolean flag = false;
            while (it.hasNext()){
                String str = it.next();
                if (isAnagram(s, str)) {
                    List<String> l = map.get(str);
                    l.add(s);
                    map.replace(str, l);
                    flag = true;
                    break;
                }
            }
            if (flag) continue; 
            else {
                List<String> l = new ArrayList<>();
                l.add(s);
                map.put(s, l);
            }
        }
        return map.values().stream().toList();
    }

    public boolean isAnagram(String s, String t) {
        if (s.length()!=t.length()) return false;

        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map1.put(s.charAt(i), map1.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            map2.put(t.charAt(i), map2.getOrDefault(t.charAt(i), 0) + 1);
            if (!map1.containsKey(t.charAt(i)) || (map1.get(t.charAt(i)) < map2.get(t.charAt(i)))) return false;
        }

        return true;
    }
}

