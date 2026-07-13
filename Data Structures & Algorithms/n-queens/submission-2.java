class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        
        help(res, new ArrayList<>(), n);

        return res;
    }

    private void help(List<List<String>> res, List<String> list, int n) {
        List<String> l = new ArrayList<>(list);
        int c = 0;
        StringBuilder str = new StringBuilder();
        while (c < n) {
            str.append(".");
            c++;
        }

        for (int i = 0; i < n; i++) {
            //System.out.println(l);
            str.setCharAt(i, 'Q');
            if (isValid(l, i - 1, i, i + 1)) {
                l.add(str.toString());

                if (l.size() == n) {
                    List<String> lr = new ArrayList<>(l);
                    res.add(lr);
                    l.remove(l.size() - 1);
                    continue;
                }

                help(res, l, n);
                l.remove(l.size() - 1);
            }
            str.setCharAt(i, '.');
        }
    }

    private boolean isValid(List<String> list, int l, int c, int r) {
        for (int i = list.size() - 1; i >= 0; i--) {
            String s = list.get(i);
            if ((l >= 0 && s.charAt(l) == 'Q') || s.charAt(c) == 'Q' || (r < s.length() && s.charAt(r) == 'Q')) return false;
            l--;
            r++;
        }

        return true;
    }
}
