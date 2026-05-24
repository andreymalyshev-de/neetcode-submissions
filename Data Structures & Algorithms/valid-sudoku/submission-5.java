class Solution {
    public boolean isValidSudoku(char[][] board) {
        // check the columns
        for (char[] cs: board) {
            HashSet<Character> hs = new HashSet<>();
            for (char c: cs) {
                if (hs.contains(c) && c != '.') {
                    System.out.println(c);
                    return false;
                }
                else hs.add(c);
            }
        }

        // check the rows
        for (int i = 0; i < 9; i++) {
            HashSet<Character> hs = new HashSet<>();
            for (char[] cs: board) {
                char c = cs[i];
                if (hs.contains(cs[i]) && cs[i] != ('.')) {
                    System.out.println(c);
                    return false;
                }
                else hs.add(c);
            } 
        }

        // check 3x3
        for (int col = 0; col < 3; col++) {
            for (int row = 0; row < 3; row++) {
                HashSet<Character> hs = new HashSet<>();
                for (int i = 0; i < 3; i++) {
                    char[] cs = board[i + row*3];
                    for (int j = 0; j < 3; j++) {
                        char c = cs[j + col*3];
                        if (hs.contains(c) && c != ('.')) {
                            System.out.println("mistake in row: " + (i + row*3) + ", col: " + (j + col*3));
                            System.out.println(c);
                            return false;
                        }
                        else {
                            System.out.println("what to add: " + c);
                            hs.add(c);
                        }
                    }
                }
                System.out.println("------");
            }
        }
        return true;
    }
}
