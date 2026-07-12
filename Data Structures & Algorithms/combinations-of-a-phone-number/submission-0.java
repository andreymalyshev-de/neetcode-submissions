class Solution {
    public HashMap<Integer, Set<Character>> hm;

    public List<String> letterCombinations(String digits) {
        hm = new HashMap<>();
        int c = 97;
        for (int i = 2; i < 10; i++) {
            Set<Character> s = new HashSet<>();
            if (i != 7 && i != 9) {
                int tmp = 3;
                while (tmp > 0) {
                    s.add((char)c);
                    c++;
                    tmp--;
                }
            } 
            else {
                int tmp = 4;
                while (tmp > 0) {
                    s.add((char)c);
                    c++;
                    tmp--;
                }
            }
            hm.put(i, s);
            System.out.println(i + " " + hm.get(i));
        }

        return help(0, digits, "");
    }

    private List<String> help(int pos, String digits, String str) {
        List<String> res = new ArrayList<>();
        if (pos >= digits.length()) {
            if (pos > 0) res.add(str);
            return res;
        }
        StringBuilder cur = new StringBuilder(str);
        System.out.println("pos: " + pos + " int: " + digits.charAt(pos) + " " + hm.containsKey(Integer.parseInt(digits.substring(pos, pos + 1))) + " ");

        Iterator<Character> it = hm.get(Integer.parseInt(digits.substring(pos, pos + 1))).iterator();
        while (it.hasNext()) {
            cur.append(it.next());
            res.addAll(help(pos + 1, digits, cur.toString()));
            cur.deleteCharAt(cur.length() - 1);
        }

        return res;
    }
}
