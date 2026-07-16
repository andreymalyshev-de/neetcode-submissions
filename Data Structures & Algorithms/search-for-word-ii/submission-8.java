class Solution {
    public List<String> res;

    public List<String> findWords(char[][] board, String[] words) {
        res = new ArrayList<>();
        TrieNode root = new TrieNode(-1);

        for (int s = 0; s < words.length; s++) {
            HashMap<Character, TrieNode> kids = root.hm;
            for (int i = 0; i < words[s].length(); i++) {
                TrieNode cur;
                if (i == words[s].length() - 1) {
                    if (!kids.containsKey(words[s].charAt(i))) {
                        cur = new TrieNode(s);
                        cur.ref++;
                        kids.put(words[s].charAt(i), cur);
                    }
                    else {
                        cur = kids.get(words[s].charAt(i));
                        cur.ref++;
                        cur.idx = s;
                    }
                }
                else {
                    if (!kids.containsKey(words[s].charAt(i))) {
                        cur = new TrieNode(-1);
                        cur.ref++;
                        kids.put(words[s].charAt(i), cur);
                        kids = cur.hm;
                    }
                    else {
                        cur = kids.get(words[s].charAt(i));
                        cur.ref++;
                        kids = cur.hm;
                    }
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                help(board, i, j, root, words);
            }
        }

        return res;
    }

    private void help(char[][] board, int i, int j, TrieNode node, String[] words) {

        if (!node.hm.containsKey(board[i][j])) return;  
        else {
            TrieNode tmp = node.hm.get(board[i][j]);
            if (tmp.idx != -1) {
                res.add(words[tmp.idx]);
                tmp.ref--;
                tmp.idx = -1;
                if (tmp.ref == 0) node.hm.remove(board[i][j]);
                node.ref--;
            }
            if (tmp.ref != 0) {
                int ref = tmp.ref;
                char c = board[i][j];
                board[i][j] = '-';
                if (i > 0) {
                    help(board, i - 1, j, tmp, words);
                    if (tmp.ref < ref) {
                        node.ref -= (ref - tmp.ref);
                        ref = tmp.ref;
                    }
                    if (tmp.ref == 0) {
                        node.hm.remove(c);
                        board[i][j] = c;
                        return;
                    }
                }
                if (j > 0) {
                    help(board, i, j - 1, tmp, words);
                    if (tmp.ref < ref) {
                        node.ref -= (ref - tmp.ref);
                        ref = tmp.ref;
                    }
                    if (tmp.ref == 0) {
                        node.hm.remove(c);
                        board[i][j] = c;
                        return;
                    }
                }
                if (j < board[i].length - 1) {
                    help(board, i, j + 1, tmp, words);
                    if (tmp.ref < ref) {
                        node.ref -= (ref - tmp.ref);
                        ref = tmp.ref;
                    }
                    if (tmp.ref == 0) {
                        node.hm.remove(c);
                        board[i][j] = c;
                        return;
                    }
                }
                if (i < board.length - 1) {
                    help(board, i + 1, j, tmp, words);
                    if (tmp.ref < ref) {
                        node.ref -= (ref - tmp.ref);
                        ref = tmp.ref;
                    }
                    if (tmp.ref == 0) {
                        node.hm.remove(c);
                        board[i][j] = c;
                        return;
                    }
                }
                board[i][j] = c;
            }
        }
    }

    class TrieNode {
        public int ref;
        public int idx;
        public HashMap<Character, TrieNode> hm;

        public TrieNode(int idx) {
            this.idx = idx;
            this.hm = new HashMap<>();
            this.ref = 0;
        }
    }
}
