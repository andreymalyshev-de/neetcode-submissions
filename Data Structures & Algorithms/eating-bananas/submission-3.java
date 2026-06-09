class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        //i make a binary search on the max ban per h in between [1, max ban in a pile] until i find the best

        int max = 0;
        for (int i = 0; i < piles.length; i++) {
            if (piles[i] > max) max = piles[i];
        }

        int l = 1;
        int r = max;
        int i = 0;

        while (l <= r) {
            int c = 0; // hours counter
            i = l + (r - l) / 2;
            for (int p: piles) {
                c += (int)Math.ceil((double)p / i);
            }
            System.out.println("i: " + i + " c: " + c);
            if (c > h) {
                l = i + 1;
            }
            else {
                r = i - 1;
            }
        }

        int c = 0;
        for (int p: piles) {
            c += (int)Math.ceil((double)p / i);
        }

        return l;
    }
}
