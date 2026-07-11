class Solution {
    public List<List<String>> partition(String s) {
        return help(s, "", new ArrayList<>());
    }

    private List<List<String>> help(String s, String c, List<String> list) {
        List<List<String>> res = new ArrayList<>();
        if (s.equals("") && !isPalindrome(c)) return res;
        List<String> cur = new ArrayList<>(list);
        StringBuilder str = new StringBuilder(c);

        for (int i = 0; i < s.length(); i++) {
            str.append(s.charAt(i));
            //System.out.println(str.toString());
            //System.out.println(isPalindrome(str.toString()));
            if (i + 1 < s.length()) res.addAll(help(s.substring(i + 1, s.length()), str.toString(), cur));
            if (!isPalindrome(str.toString())) return res;
            cur.add(str.toString());
            //System.out.println("res: " + res);
            //System.out.println("cur: " + cur);
            str = new StringBuilder();
        }

        res.add(cur);

        return res;
    }

    private boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            if (s.charAt(r) != s.charAt(l)) return false;
            l++;
            r--;
        }

        return true;
    }
}
