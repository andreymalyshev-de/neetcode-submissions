class Solution {
    public List<String> generateParenthesis(int n) {
        return new ArrayList<>(help(new StringBuilder(), 0, n, n));
    }

    private Set<String> help(StringBuilder str, int k, int tmp, int n) {
        //if (n == 0) return new ArrayList<>(s.toString());
        StringBuilder s = new StringBuilder(str);
        Set<String> res = new HashSet<>();
        
        while (k < n && tmp > 0) {
            s.append("(");
            k++;
            res.addAll(help(s, k, tmp, n));
            
            while (k > n - tmp) {
                s.append(")");
                tmp--;
                res.addAll(help(s, k, tmp, n));
            }
        }

        while (tmp > 0) {
            s.append(")");
            tmp--;
        }

        //if (res.size() > 0 && !res.get(res.size() - 1).equals(s.toString())) res.add(s.toString());
        //else if (res.size() == 0) res.add(s.toString());
        res.add(s.toString());
        return res;
    }
}
