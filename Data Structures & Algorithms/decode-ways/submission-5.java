class Solution {
    public int numDecodings(String s) {
        // i need to know how many ways there were for i-1 and i-2.
        // bcs in case i can combine i-1 and i i need to add the possibilities of 
        // i standing alone to i being combined
        
        if (s.isEmpty() || s.charAt(0) == '0') return 0;
        int snd = 1;
        int fst = 1;

        // 226
        // 1 1
        // 1 2
        // 2 3

        // 226
        // 1 1
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '0') {
                if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2') {
                    fst = snd;
                }
                else return 0;
            }
            else {
                if (s.charAt(i - 1) == '1') {
                    int tmp = fst;
                    fst += snd;
                    snd = tmp;
                }
                else if (s.charAt(i - 1) == '2' && c - '0' < 7) {
                    int tmp = fst;
                    fst += snd;
                    snd = tmp;
                } 
                else {
                    snd = fst;
                }
            }
        }

        return fst;
    }
}
