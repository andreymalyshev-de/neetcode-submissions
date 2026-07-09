class Solution {
    public List<String> generateParenthesis(int n) {
        return help(new StringBuilder(), 0, 0, n);
    }

    public List<String> help(StringBuilder str, int op, int cl, int n) {
        List<String> res = new ArrayList<>();
        if (op == cl && op == n) {
            res.add(str.toString());
            return res;
        }

        if (op < n) {
            str.append("(");
            res.addAll(help(str, op + 1, cl, n));
            str.deleteCharAt(str.length() - 1);
        }

        if (cl < n && cl < op) {
            str.append(")");
            res.addAll(help(str, op, cl + 1, n));
            str.deleteCharAt(str.length() - 1);
        }
        
        return res;
    }

}
