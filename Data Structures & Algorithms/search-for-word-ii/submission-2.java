class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();

        for (char[] c: board) {
            System.out.println(Arrays.toString(c));
        }

        for (String s: words) {
            if (help(board, 0, 0, 0, s)) res.add(s);
        }

        return res;
    }

    private boolean help(char[][] board, int i, int j, int s, String word) {

        for (i = i; i < board.length; i++) {
            if (word.equals("eat")) System.out.println(word.charAt(s) + " " + i + " " + j);
            for (j = j; j < board[i].length; j++) {
                if (word.equals("eat")) System.out.println(word.charAt(s) + " " + i + " " + j);
                if (word.charAt(s) == board[i][j]) {
                    if (s == word.length() - 1) return true;
                    s++;
                    board[i][j] = '-';
                    if (i > 0 && word.charAt(s) == board[i - 1][j] && help(board, i - 1, j, s, word)) {
                        s--;
                        board[i][j] = word.charAt(s);
                        return true;
                    }
                    if (j > 0 && word.charAt(s) == board[i][j - 1] && help(board, i, j - 1, s, word)) {
                        s--;
                        board[i][j] = word.charAt(s);
                        return true;
                    }
                    if (j < board[i].length - 1 && word.charAt(s) == board[i][j + 1] && help(board, i, j + 1, s, word)) {
                        s--;
                        board[i][j] = word.charAt(s);
                        return true;
                    }
                    if (i < board.length - 1 && word.charAt(s) == board[i + 1][j] && help(board, i + 1, j, s, word)) {
                        s--;
                        board[i][j] = word.charAt(s);
                        return true;
                    }
                    s--;
                    board[i][j] = word.charAt(s);
                    if (s > 0) return false;
                }
            }
            j = 0;
        }
        return false;
    }
}
