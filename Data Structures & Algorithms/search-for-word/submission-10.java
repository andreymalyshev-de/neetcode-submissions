class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (help(board, word, 0, i, j)) return true;
            }
        }
        return false;
    }

    private boolean help(char[][] board, String word, int sn, int i, int j) {

                char c = board[i][j];
                //System.out.println(c + " " + i + " " + j);
                //System.out.println(c + '\n' + Arrays.toString(board));
                if (c == word.charAt(sn)) {
                    board[i][j] = '-';
                    sn++;
                    if (sn == word.length()) return true;
                    if (i > 0 && board[i - 1][j] == word.charAt(sn)) {
                        if (help(board, word, sn, i - 1, j)) return true;
                    }
                    if (j > 0 && board[i][j - 1] == word.charAt(sn)) {
                        if (help(board, word, sn, i, j - 1)) return true;
                    }
                    if (j < board[i].length - 1 && board[i][j + 1] == word.charAt(sn)) {
                        if (help(board, word, sn, i, j + 1)) return true;
                    }
                    if (i < board.length - 1 && board[i + 1][j] == word.charAt(sn)) {
                        if (help(board, word, sn, i + 1, j)) return true;
                    }
                    sn--;
                    board[i][j] = c;
                    if (sn != 0) return false;
                }

        return false;
    }
}
