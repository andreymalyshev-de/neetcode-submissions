class Solution {
    public void solve(char[][] board) {
        int[][] visited = new int[board.length][board[0].length];
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[i].length; j++) {
                if (i == 0 || i == visited.length - 1 || j == 0 || j == visited[i].length - 1) {
                    if (board[i][j] == 'O') visited[i][j] = 1;
                }
            }
        }

        for (int i = 1; i < visited.length - 1; i++) {
            for (int j = 1; j < visited[i].length - 1; j++) {
                if (board[i][j] == 'O' && visited[i][j] != 1) {
                    if ( visited[i-1][j] == 1 || visited[i][j-1] == 1 ||
                            visited[i+1][j] == 1 || visited[i][j+1] == 1) {
                        visited[i][j] = 1;
                    }
                }
            }
        }

        for (int i = visited.length - 1; i > 0; i--) {
            for (int j = visited[i].length - 1; j > 0; j--) {
                if (board[i][j] == 'O' && visited[i][j] != 1) {
                    if (visited[i-1][j] == 1 || visited[i][j-1] == 1 ||
                            visited[i+1][j] == 1 || visited[i][j+1] == 1) {
                        visited[i][j] = 1;
                    }
                }
            }
        }

        for (int i = 1; i < visited.length - 1; i++) {
            for (int j = 1; j < visited[i].length - 1; j++) {
                if (board[i][j] == 'O' && visited[i][j] != 1) {
                    if ( visited[i-1][j] == 1 || visited[i][j-1] == 1 ||
                            visited[i+1][j] == 1 || visited[i][j+1] == 1) {
                        visited[i][j] = 1;
                    }
                }
            }
        }


        for (int i = 1; i < visited.length - 1; i++) {
            for (int j = 1; j < visited[i].length - 1; j++) {
                if (board[i][j] == 'O' && visited[i][j] != 1) {
                    board[i][j] = 'X';
                }
            }
        }

    
    }
}