class Solution {
    int cnt = 0;
    public void solve(char[][] board) {
        
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O') {
                help(board, i, 0);
            }
            if (board[i][board[i].length - 1] == 'O') {
                help(board, i, board[i].length - 1);
            }
        }

        for (int j = 0; j < board[0].length; j++) {
            if (board[0][j] == 'O') {
                help(board, 0, j);
            }
            if (board[board.length - 1][j] == 'O') {
                help(board, board.length - 1, j);
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == '-') board[i][j] = 'O';
            }
        }

    }







    private void help(char[][] board, int i, int j) {
        //System.out.println(i + " " + j);
        if (i < 0 || j < 0 || i >= board.length || j >= board[i].length ||
        board[i][j] != 'O') return;

        board[i][j] = '-';

        help(board, i - 1, j);
        help(board, i, j - 1);
        help(board, i + 1, j);
        help(board, i, j + 1);
    }

    public void help2(char[][] board, int[][] visited, int i, int j, char c) {
        if (board[i][j] != '-') return;

        board[i][j] = c;
        if (c == 'O') visited[i][j] = 1;
        
        help2(board, visited, i - 1, j, c);
        help2(board, visited, i, j - 1, c);
        help2(board, visited, i + 1, j, c);
        help2(board, visited, i, j + 1, c);
    }
}
